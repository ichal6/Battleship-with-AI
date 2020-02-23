import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    public void printOcean(Ocean currentOcean, boolean hasGameStarted) {
        System.out.println(currentOcean.toString(hasGameStarted));
    }

    public void printPossibleShips(HashMap<String, Integer> possibleShips) {
        System.out.println(" You can choose among following ships: ");
        int index = 1;
        for (Map.Entry<String, Integer> ship: possibleShips.entrySet()) {
            System.out.println(String.format(" %d. Name: %s. Number of cells: %d", index, ship.getKey(), ship.getValue()));
            index += 1;
        }
        System.out.println("");
    }

    public String inputFromUser(String textToView){
        System.out.println(" " + textToView + ":");
        System.out.print(" ");
        Scanner scannerFromUser = new Scanner(System.in);
        String input = scannerFromUser.nextLine();
        
        return input;
    }

    public void printTitle(String title){
        System.out.println("");
        System.out.println(" " + title.toUpperCase());
        System.out.println("");
    }

    public void printText(String text){
        System.out.println(" " + text);
    }

    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}