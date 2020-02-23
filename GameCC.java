public class GameCC extends GameAI {
    

    public GameCC(int level){
        setDifficultyLevel(level);
        view = new View();
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

}