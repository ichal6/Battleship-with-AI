public abstract class Game{
    protected boolean hasStarted;
    protected Player currentPlayer;
    protected Player player1;
    protected Player player2;

    abstract void prepareToGame();

    public boolean getHasStarted() {
        return hasStarted;
    }

    public String turnOfPlayer(){
        if (currentPlayer == player1) {
            return player2.getName();
        } else {
            return player1.getName();
        }
    }

    public void changeCurrentPlayer() {
        if (currentPlayer.getName() == player1.getName()) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void setHasStarted(boolean hasStarted){
        this.hasStarted = hasStarted;
    }

    public void setPlayer1(Player player){
        this.player1 = player;
    }

    public void setPlayer2(Player player){
        this.player2 = player;
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }

    public Player getPlayer2(){
        return player2;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
}
