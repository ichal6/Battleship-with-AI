__[back to README](../README.md)__

# Description
This class is used to launch game. 

# Fields
* **hasStarted** - type boolean - contains information whether the game has started (true) or is still in the preparation mode (false).
* **currentplayer** - type Player - contains reference to actual player. Changes after each turn of the game.
* **player1** - type Player - contain reference to object Player one
* **player2** - type Player - contain reference to object Player two
* **view** - type View - use to launch view methods

# Methods
1. Game()
    * This contructor launches new game object, which prepares and starts new game.

2. prepareToGame()
    * This method creates two objects type Player (that include asking for player's name and placing their ships) and set currentPlayer field

3. playGame()
    * This method:
        * gets coordinates from user.
        * sends coordinates to shoot method.
        * displays information about hit or miss.
        * checks condition about end of game.

4. shoot(int[] coordinatesAsInt)
    * this method returns information about hit or miss.

5. getCoordinates(String coordinatesAsString)
    * this method converts coordinates from string format to int array.

6. getHasStarted()
    * this method returns a value of hasStarted field.

7. turnOfPlayer()
    * this method returns a name of the opponent of the current player.

8. changeCurrentPlayer()
    * This method changes value of currentPlayer field.

9. checkCoordinates(String coordinatesAsString)
    * this method checks if coordinatesAsString contain correct value.
    * If the value is correct, method return true, else return false.

10. transformToCorrectCoordinates(String coordinatesAsString)
    * This method checks if input from user is not obverse.
    * If it is true, method sets coordinates in correct order.
    * Method returns coordiantesAsString.

11. translateFromStringToCoordinates(String[] coordinatesAsString)
    * This method converts coordinates from String format to int array.
    * And next method returns int array of coordinates.

12. isNumeric(String strNum)
    * This method checks if strNum contain __only__ number.
    * If the value is only numeric, method returns true, if not it returns false. 
    