import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlayerHuman extends Player {
    
    private View view;
    private HashMap<String, Integer> possibleShips;
    {
        possibleShips = new HashMap<>();
        // possibleShips.put("Carrier", 5);
        // possibleShips.put("Battleship", 4);
        // possibleShips.put("Cruiser", 3);
        // possibleShips.put("Submarine", 3);
        possibleShips.put("Destroyer", 2);
    }

    public PlayerHuman(String numOfUser){
        super();
        askForName(numOfUser);
        setOcean(new Ocean());
        view = new View();
        askForShips(); // <--- odkomentować do właściwej gry!!!
    }

    public boolean hasLost(){
        return getOcean().hasLost();
    }

    public boolean shoot(int[] coordinates){
        return getOcean().isShot(coordinates[0],coordinates[1]);
    }

    public boolean isSunk(int[] coordinates){
        return getOcean().isSunk(coordinates[0], coordinates[1]);
    }

    private void askForName(String numOfUser) {
        view = new View();
        view.clearScreen();
        String name = view.inputFromUser(String.format("Please insert name of the %s user", numOfUser));
        setName(name);
        while (numOfUser.length() < 1) {
            view.printText("Your name should consist of at least 1 character");
            name = view.inputFromUser(String.format("Please insert name of the %s user", numOfUser));
            setName(name);
        }
    }

    private void askForShips() { 
        while (possibleShips.size() > 0) {
            view.clearScreen();
            view.printTitle(String.format("%s - time to place your ships!", getName()));
            view.printOcean(getOcean(), false);
            view.printPossibleShips(possibleShips);
            
            String shipName = getShipName();
            int shipLength = possibleShips.get(shipName);
            boolean isHorizontal = getIsShipHorizontal();
            int[] coordinates = getShipCoordinates();

            boolean isAdded = getOcean().addShip(coordinates[0], coordinates[1], isHorizontal, shipLength);

            if (isAdded) {
                possibleShips.remove(shipName);
            } 
        }
    }
    
    private String getShipName() {
        String shipName = view.inputFromUser("Please type in the name of the ship you choose");
        shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
        
        while (!possibleShips.containsKey(shipName)){
            view.printText("This name is not on the list of permitted ships"); 
            shipName = view.inputFromUser("Please type in the name of the ship you choose");
            shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
        }
        return shipName;
    }

    private boolean getIsShipHorizontal() {
        String order = "Please type H if you want your ship to be HORIZONTAL or V if VERTICAL";
        String position = view.inputFromUser(order).toUpperCase();

        while (!position.equals("H") && !position.equals("V")) {
            view.printText("Wrong input.");
            position = view.inputFromUser(order).toUpperCase();
        }
        boolean isHorizontal = (position.equals("H")) ? true : false;
        
        return isHorizontal;
    }

    private int[] getShipCoordinates() {
        String order = "What is the starting point of your ship? Type it in '1A' format";
        String coordinates = view.inputFromUser(order).toUpperCase();
        
        String[] possibleNumbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<String> possibleNumbersList = Arrays.asList(possibleNumbers);
        String[] possibleLetters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        List<String> possibleLettersList = Arrays.asList(possibleLetters);
        
        String firstSign = (coordinates.length() > 2) ? coordinates.substring(0,2) : coordinates.substring(0,1);
        String secondSign = (coordinates.length() > 2) ? coordinates.substring(2) : coordinates.substring(1);
        
        while (!possibleLettersList.contains(secondSign) || !possibleNumbersList.contains(firstSign) 
                || (coordinates.length() > 2 && !coordinates.substring(0,2).equals("10"))) 
            {
            coordinates = view.inputFromUser(order).toUpperCase();
            firstSign = (coordinates.length() > 2) ? coordinates.substring(0,2) : coordinates.substring(0,1);
            secondSign = (coordinates.length() > 2) ? coordinates.substring(2) : coordinates.substring(1);
        }
        int[] finalCoordinates = translateFromStringToCoordinates(coordinates);

        return finalCoordinates;
    }

    private int[] translateFromStringToCoordinates(String coordinatesAsString){
        String[] alfabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int lenghtArrayOfAlfabet = alfabet.length;
        int X_INDEX = 1;
        int Y_INDEX = 0;
        int[] coordinatesAsInt = new int[] {1, 2};
        String xAsString = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(0,2) : coordinatesAsString.substring(0,1);
        String yAsString = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(2) : coordinatesAsString.substring(1);
        
        coordinatesAsInt[X_INDEX] = Integer.parseInt(xAsString) - 1;
        
        for(int index = 0; index < lenghtArrayOfAlfabet; index++){
            if(yAsString.equals(alfabet[index])){
                coordinatesAsInt[Y_INDEX] = index;
            }
        }
        return coordinatesAsInt;
    }
}