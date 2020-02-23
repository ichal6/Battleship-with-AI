import java.util.ArrayList;
import java.util.List;

public class Ocean{

    List<ArrayList<Square>> board;
    List<Ship> shipsArray;

    final static int WIDTH = 10;
    final static int HEIGHT = 10;
    
    public Ocean(){
        this.shipsArray = new ArrayList<Ship>();
        this.board = new ArrayList<ArrayList<Square>>();
        for(int iRow = 0; iRow < HEIGHT; iRow++ ){
            ArrayList<Square> row = new ArrayList<Square>();
            
            for(int iCol = 0; iCol < WIDTH; iCol++){
                Square newSquare = new Square();
                row.add(newSquare);
            }
            this.board.add(row);
        }

    }

    public boolean isShot(int x, int y){
        for(Ship ship: shipsArray){
            if(ship.isShot(board.get(y).get(x))){
                return true;
            }
        }
        return false;
    } 

    public boolean isSunk(int x, int y){
        for(Ship ship: shipsArray){
            if(ship.isSquareInShip(board.get(y).get(x))){
                if(ship.isSunk()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addShip(int x, int y, boolean isHorizontal, int length){
        boolean isValid = validateNotHangOffEdge(x, y, isHorizontal, length);
        if (isValid == true) {
            isValid = validateNotOverlap(x, y, isHorizontal, length);
        }

        if(!isValid){
            return false;
        }
        List<Square> squaresArray = new ArrayList<Square>();
        List<Square> reservedFieldsArray = new ArrayList<Square>();

        for(int index = 0; index < length; index++){
            int[] coordinates = (isHorizontal) ? new int[]{y, x+index} : new int[]{y+index, x};
            squaresArray.add(board.get(coordinates[0]).get(coordinates[1]));
            addReservedFields(coordinates[1], coordinates[0], reservedFieldsArray);
        }
        Ship newShip = new Ship(squaresArray, reservedFieldsArray);
        shipsArray.add(newShip);

        return true;
    }

    public boolean hasLost(){
        for(Ship ship: shipsArray){
            if(!ship.isSunk()){
                return false;
            }
        }
        return true;
    }

    private void addReservedFields(int x, int y, List<Square> reservedFieldsArray){
        int[] arrayCol = new int[]{y+1, y+1, y, y-1, y-1, y-1, y, y+1};
        int[] arrayRow = new int[]{x, x+1, x+1, x+1, x, x-1, x-1, x-1};
        final int RESERVED_FIELDS_NUMBER = 8;
        
        for(int index = 0; index < RESERVED_FIELDS_NUMBER; index++){
            if(arrayCol[index] < WIDTH && arrayRow[index] < HEIGHT && arrayCol[index] >= 0 
               && arrayRow[index] >= 0)
                reservedFieldsArray.add(board.get(arrayCol[index]).get(arrayRow[index]));
        }
    }

    private boolean validateNotHangOffEdge(int x, int y, boolean isHorizontal, int length){
        if(x < 0 || y < 0 ||  x > WIDTH || y > HEIGHT){
            return false;
        }
        if(isHorizontal){
            if(x+length > WIDTH){
                return false;
            }   
        }
        else{
            if(y+length > HEIGHT){
                return false;
            }
        }
        return true;
    }

    private boolean validateNotOverlap(int x, int y, boolean isHorizontal, int length) 
                                        throws IllegalArgumentException 
        { // czy to wystarczy jako obsługa wyjątków?
        for(int index = 0; index < length; index++){
            
            int[] coordinates = (isHorizontal) ? new int[]{y, x+index} : new int[]{y+index, x};
            
            if(board.get(coordinates[0]).get(coordinates[1]).getIsShip() 
                || board.get(coordinates[0]).get(coordinates[1]).getIsReserved()){   
                return false;
            }
        }
        return true;
    }
    
    public String toString(boolean hasGameStarted) {
        String boardString = "     A  B  C  D  E  F  G  H  I  J \n";
        int index = 1;
        for(ArrayList<Square> row : board){
            boardString += String.format(" %2d ", index);
            for(Square singleSquare : row){
                boardString += singleSquare.toString(hasGameStarted);
            }
            boardString += "\n";
            index += 1;
        }
        return boardString;
    }
}
