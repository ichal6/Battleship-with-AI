public class Square{
    private boolean isShip;
    private boolean isReserved;
    private boolean isChosen;

    public Square(){
        isShip = false;
        isReserved = false;
        isChosen = false;
    }

    public boolean getIsShip(){
        return isShip;
    }

    public void setShip(){
        isShip = true;
    }

    public boolean getIsReserved(){
        return isReserved;
    }

    public void setReserved(){
        isReserved = true;
    }

    public boolean getIsChosen(){
        return isChosen;
    }

    public void setChosen(){
        isChosen = true;
    }

    public String toString(boolean hasGameStarted){ 
        String symbol;
        if (hasGameStarted) {
            if (isShip && isChosen) {
                symbol = " x ";
            } else if (!isShip && isChosen) {
                symbol = " o ";
            } else {
                symbol = " . ";
            }
        } else {
            symbol = (isShip) ? " x " : " . ";
        }
        return symbol;
    }
}