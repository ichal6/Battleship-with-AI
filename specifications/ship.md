__[back to README](../README.md)__

# Description
This class is used to create one ship on board or check whether it was shot or sunk. 

# Fields
* **listOfSquaresInShip** - type List<Square> - This list contain squares which are part of ship 

# Methods
1. Ship(List<Square> newShipSquaresArray, List<Square> reservedFieldsArray)
    * This costructor creates a new ship by adding its fields to listOfSquaresInShip and changing their isShip fields to true.
    * It also takes the array of reserved fields and change their isReserved field to true.

2. isSunk()
    * This method returns true if all of Squares in Ship was shot. If not method returns false.

3. isSquareInShip(Square findSquare)
    * This method returns true if Ship contains findSquare.

4. isShot(Square squareWithCoordinates)
    * This method changes isChosen field in Square to true value. 
    * It returns true if square is part of Ship. If else, it returns false.