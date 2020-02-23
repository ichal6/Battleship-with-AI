__[back to README](../README.md)__

# Description
This class is used to create one cell of board. 

# Fields
* **isShip** - type boolean - informs user if this square is part of a ship.
* **isReserved** - type boolean - informs user if on this square user can put a ship.
* **isChosen** - type boolean - informs user if this square has been shot.

# Methods
1. getIsShip()
    * This method returns default value(boolean) of fields isShip.
    
2. setShip()
    * This method sets field isShip as true.
    * This method doesn't have any return value.

3. getIsReserved()
    * This method returns value(boolean) of fields isReserved.

4. setReserved()
    * This method sets field isReserved as true.
    * This method doesn't have any return value.

5. getIsChosen()
    * This method returns value(boolean) of fields isChosen.

6. setChosen()
    * This method sets field isChosen as true.
    * This method doesn't have any return value.

7. toString(Game currentGame)
    * This method returns Square as a String.
    * It gets one parameter:
        * boolean - hasGameStarted. 
    
