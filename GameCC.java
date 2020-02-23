import java.util.Random;

public class GameCC extends Game {
    private int difficultyLevel;
    private Random generator;
    public View view;

    public GameCC(int difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        view = new View();
        generator = new Random(); 
        setHasStarted(false);
        prepareToGame();
        playGame();
    }

    void prepareToGame() {
        setPlayer1(new PlayerComp("first"));
        setPlayer2(new PlayerComp("second"));

        setCurrentPlayer(getPlayer2());
    }

    private void playGame() {
        setHasStarted(true);
        String textToDisplay = "";
        boolean isGaming = true;
        while(isGaming){
            view.clearScreen();
            view.printTitle(String.format("It's %s's turn to strike!", turnOfPlayer()));
            

            textToDisplay = shoot(getComputerCoordinates());
            view.printOcean(getCurrentPlayer().getOcean(), getHasStarted());
            view.printText(textToDisplay);

            if(getPlayer1().hasLost() || getPlayer2().hasLost()){
                isGaming = false;
            } else{
                changeCurrentPlayer();
                view.inputFromUser("Press Enter to continue");
            }
        }
        view.printText(String.format("Congratoulations %s! You Won!", turnOfPlayer()));
    }

    private String shoot(int[] coordinatesAsInt){
        boolean wasShot = getCurrentPlayer().shoot(coordinatesAsInt);
        String textToDisplay = wasShot ? "You hit!" : "You miss!";

        wasShot = getCurrentPlayer().isSunk(coordinatesAsInt);
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

        while(getCurrentPlayer().getOcean().getBoard().get(y).get(x).getIsChosen()){
            generator = new Random();
            x = generator.nextInt(10);
            y = generator.nextInt(10);
            
        }
        int[] coordinatesAsArray = new int[]{x, y};
        return coordinatesAsArray;
    }

}