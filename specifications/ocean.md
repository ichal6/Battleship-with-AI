__[back to README](../README.md)__

# Description
This class is used to create ocean for each player and operate ships on it. 

# Fields
* **board** - type List<ArrayList<Square>> - It is a list of list of Squares.
* **shipsArray** - type List<Ship> - List containong Ships.
* **WIDTH** - type final int - width of board.
* **HEIGTH** - type final int - heigth of board.

# Methods
1. Ocean()
    * The constructor that fills board with squares.

2. isShot(int x, int y)
    * This method returns true if coordinates are part of a ship.
    * If not method returns false.

3. isSunk(int x, int y)
    * This method returns true if coordinates indicate part of sunk ship.
    * If not method returns false.

4. addShip(int x, int y, boolean isHorizontal, int length)
    * This method calls validation methods and if request passes the validation, it adds new ship to the Ocean.

5. hasLost()
    * This method checks if all ships in Ocean are sunk.
    * If they are, method returns true, otherwise it returns false.

6. addReservedFields(int x, int y, List<Square> reservedFieldsArray)
    * This method adds squares around new ship to array reservedFieldsArray, to mark which fields are protected from putting other ships there.

7. validateNotHangOffEdge(int x, int y, boolean isHorizontal, int length)
    * This method checks if it is possible to add new ship with given parameters to the board.
    * it checks whether the whole ship can be placed on the given spot without any part of it hanging off the egdes.

8. validateNotOverlap(int x, int y, boolean isHorizontal, int length)
    * This method checks if new ship can be put on squares with given coordinates
    * If these coordinates are occupied by another ship, the method will return false.
    * If these coordinates are free, it will return true.

9. toString(boolean hasGameStarted)
    * This method is used to print board in human-frendly format.
