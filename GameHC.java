import java.util.Random;
import java.util.regex.Pattern;

public class GameHC {
    private boolean hasStarted;
    private Player currentPlayer;
    private Player playerHuman;
    private Player playerComp;
    private int difficultyLevel;
    private Random generator;
    public View view;

    public GameHC(int difficultyLevel){ 
        this.difficultyLevel = difficultyLevel;
        view = new View();
        generator = new Random(); 
        hasStarted = false;
        prepareToGame();
        playGame();
    }

    private void prepareToGame() {
        playerHuman = new PlayerHuman("first");
        playerComp = new PlayerComp("Computer");

        currentPlayer = playerComp;
    }

    private void playGame() {
        hasStarted = true;
        String textToDisplay = "";
        String coordinatesAsString = "";
        boolean isGaming = true;
        while(isGaming){
            view.clearScreen();
            view.printTitle(String.format("It's %s's turn to strike!", turnOfPlayer()));
            
            int[] coordinatesAsInt;
            if(currentPlayer == playerComp){
                view.printOcean(currentPlayer.getOcean(), hasStarted);
                coordinatesAsInt = getCoordinates(coordinatesAsString);
                textToDisplay = shoot(coordinatesAsInt);
                view.printText(textToDisplay);
            }
            else{
                coordinatesAsInt = getComputerCoordinates();
                textToDisplay = shoot(coordinatesAsInt);
                view.printText(textToDisplay);
                view.printOcean(currentPlayer.getOcean(), hasStarted);
            }
            
            

            if(playerHuman.hasLost() || playerComp.hasLost()){
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

    private int[] getCoordinates(String coordinatesAsString){
        String[] coordinateAsArray = new String[] {};
        boolean isIncorrectInput = true;
        
        while(isIncorrectInput){
            coordinatesAsString = view.inputFromUser("Please insert coordinates to attack").toUpperCase();
            if(checkCoordinates(coordinatesAsString)){
                isIncorrectInput = false;
                coordinateAsArray = transformToCorrectCoordinates(coordinatesAsString);
            }
        }
        int[] coordinatesAsInt = translateFromStringToCoordinates(coordinateAsArray);
        
        return coordinatesAsInt;
    }

    public boolean getHasStarted() {
        return hasStarted;
    }

    private String turnOfPlayer(){
        if (currentPlayer == playerHuman) {
            return playerComp.getName();
        } else {
            return playerHuman.getName();
        }
    }

    private void changeCurrentPlayer() {
        if (currentPlayer.getName() == playerHuman.getName()) {
            currentPlayer = playerComp;
        } else {
            currentPlayer = playerHuman;
        }
    }

    private boolean checkCoordinates(String coordinatesAsString){
        Pattern pattern = Pattern.compile("([1-9][0]?[A-J])|([A-J][0-9][0]?)");
        
        if (coordinatesAsString == null) {
            return false; 
        }
        return pattern.matcher(coordinatesAsString).matches();
    }

    private String[] transformToCorrectCoordinates(String coordinatesAsString){
        Pattern pattern = Pattern.compile("([1-9][0]?[A-J])");
        String[] arrayCoordinates = new String[] {"", ""};

        if(pattern.matcher(coordinatesAsString).matches()){
            arrayCoordinates[0] = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(0,2) : coordinatesAsString.substring(0,1);
            arrayCoordinates[1] = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(2) : coordinatesAsString.substring(1);
        } else{
            arrayCoordinates[0] = coordinatesAsString.substring(0,1);
            arrayCoordinates[1] = coordinatesAsString.length() > 2 ? coordinatesAsString.substring(1,3) : coordinatesAsString.substring(1,2);
        }        
        return arrayCoordinates;
    }
    
    private int[] translateFromStringToCoordinates(String[] coordinatesAsString){
        String[] alfabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int lenghtArrayOfAlfabet = alfabet.length;
        int X_INDEX = 1;
        int Y_INDEX = 0;
        int[] coordinatesAsInt = new int[] {-1, -1};
        String xAsString = coordinatesAsString[X_INDEX];
        String yAsString = coordinatesAsString[Y_INDEX];
        
        if(!isNumeric(xAsString)){
            String temp = xAsString;
            xAsString = yAsString;
            yAsString = temp;
        }
        coordinatesAsInt[X_INDEX] = Integer.parseInt(xAsString) - 1;
        for(int index = 0; index < lenghtArrayOfAlfabet; index++){
            if(yAsString.equals(alfabet[index])){
                coordinatesAsInt[Y_INDEX] = index;
            }
        }
        return coordinatesAsInt;
    }

    private boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("\\d+");

        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
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
}