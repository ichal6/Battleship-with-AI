public class Main{

    public static View view = new View();
    public static void main(String[] args){
        boolean isCorrect = false;
        view.printTitle("Welcome to Battleship game!");
        int option = 0;
        while(!isCorrect){
            try {
                option = view.intFromUser("Please choose game mode:\n 1. Human vs Human\n 2. Human vs Computer \n 3. Computer vs Computer");
                isCorrect = true;
            } catch (Exception e) {
                view.printText("You wrote incorrect number!");
            }
        }

        switch(option){
            case 1:
                new GameHH();
                break;
            case 2:
                new GameHC(1);
                break;
            case 3:
                new GameCC(1);
                break;
        }
        
        
        //GameHH myGame = new GameHH();
        //GameCC myGame = new GameCC(1);
    }
}