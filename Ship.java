import java.util.ArrayList;
import java.util.List;

public class Ship {
    
    private List<Square> listOfSquaresInShip;
    
    public Ship(List<Square> newShipSquaresArray, List<Square> reservedFieldsArray){
        listOfSquaresInShip = new ArrayList<Square>();
        
        for(Square square : newShipSquaresArray){
            square.setShip();
            listOfSquaresInShip.add(square);
        }
        for(Square square : reservedFieldsArray){
            square.setReserved();
        }
    }

    public boolean isSunk(){
        for(Square square : listOfSquaresInShip){
            if(!square.getIsChosen()){
                return false;
            }
        }
        return true;
    }

    public boolean isSquareInShip(Square findSquare){
        for(Square square : listOfSquaresInShip){
            if(square == findSquare){
                return true;
            }
        }
        return false;
    }

    public boolean isShot(Square squareWithCoordinates){
        squareWithCoordinates.setChosen();
        for(Square square: listOfSquaresInShip){
            if(square == squareWithCoordinates){
                return true;
            }
        }
        return false;
    }
}