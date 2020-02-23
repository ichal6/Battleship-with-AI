import java.util.Random;
import java.util.regex.Pattern;

public class GameCC {
    private boolean hasStarted;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private int difficultyLevel;
    private Random generator;
    public View view;

    public GameCC(int difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        view = new View();
        generator = new Random(); 
        hasStarted = false;
        prepareToGame();
        playGame();
    }

    private void prepareToGame() {
        player1 = new PlayerComp("first");
        player2 = new PlayerComp("second");

        currentPlayer = player2;
    }

    private void playGame() {
        hasStarted = true;
        String textToDisplay = "";
        boolean isGaming = true;
        while(isGaming){
            view.clearScreen();
            view.printTitle(String.format("It's %s's turn to strike!", turnOfPlayer()));
            view.printOcean(currentPlayer.getOcean(), hasStarted);

            textToDisplay = shoot(getComputerCoordinates());
            view.printText(textToDisplay);

            if(player1.hasLost() || player2.hasLost()){
                isGaming = false;
            } else{
                changeCurrentPlayer();
                view.inputFromUser("Press Enter to continue");
            }
        }
        view.printText(String.format("Congratoulations %s! You Won!", turnOfPlayer()));
    }

    private String shoot(int[] coordinatesAsInt){
        boolean wasShot = currentPlayer.shoot(coordinatesAsInt);
        String textToDisplay = wasShot ? "You hit!" : "You miss!";

        wasShot = currentPlayer.isSunk(coordinatesAsInt);
        textToDisplay = wasShot ? "Hit and sunk!": textToDisplay;

        return textToDisplay;
    }

    private int[] getComputerCoordinates(){
        int[] coordinatesAsInt = new int[] {};
        switch(difficultyLevel){
            case 1:
                coordinatesAsInt = randomCoordinates();
                break;
            case 2:
                break;
            case 3:
                break;
        }

        return coordinatesAsInt;
    }

    private int[] randomCoordinates(){
        int x = generator.nextInt(10);
        int y = generator.nextInt(10);
        int count = 0;


        while(currentPlayer.getOcean().getBoard().get(y).get(x).getIsChosen()){
            generator = new Random();
            x = generator.nextInt(10);
            y = generator.nextInt(10);
            count++;
        }
        System.out.println(currentPlayer.getOcean().getBoard().get(y).get(x).getIsChosen());
        int[] coordinatesAsArray = new int[]{x, y};
        return coordinatesAsArray;
    }

    public boolean getHasStarted() {
        return hasStarted;
    }

    private String turnOfPlayer(){
        if (currentPlayer == player1) {
            return player2.getName();
        } else {
            return player1.getName();
        }
    }

    private void changeCurrentPlayer() {
        if (currentPlayer.getName() == player1.getName()) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}