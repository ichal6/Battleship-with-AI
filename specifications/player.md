__[back to README](../README.md)__

# Description
This class is used to define player, create their Ocean and place ships in the Ocean. 

# Fields
* **name** - type String - contains information about a name of player.
* **ocean** - type Ocean - player's ocean.
* **view** - type View - object view used to display informations.
* **possibleShips** - type Hashmap - dictionary of all the possible ships and their length.


# Methods
1. Player(String numOfUser)
    * The constructor asks for user's name.
    * It creates new Ocean and new View objects.
    * It calls the method askForShips (with its help the player can place their ships on the Ocean).

2. hasLost()
    * calls method hasLost from Ocean and returns its value.

3. shoot(int[] coordinates)
    * This method calls method isShoot from Ocean and returns its result.

4. isSunk(int[] coordinates)
    * This method takes coordinates of Square.
    * It returns true if the ship containing this Square is sunk.

5. askForName(String numOfUser)
    * This method asks user about their name.
    * It validates the answer until the name is at least 1 character long.

6. askForShips()
    * This is a collective method that asks player to tell which ship they want to place, where and in which position.
    * The called methods validate user's inputs
    * When the correct input is given, it calls the metho that adds the ship (if the place is accessible) to the Ocean.
    * The method is called until there is no more ships left in the possibleShips list.

7. getShipName()
    * This method asks user about what type of ship user would like to put in ocean.
    * The method returns name of ship in String type

8. getIsShipHorizontal()
    * This method asks user about setting ship in board, horizontal or vertical.
    * If the answer is horizontal, the method returns true.
    * If the answer is vertical, the method returns false.

9. getShipCoordinates()
    * This method asks user about coordinaters new ship.
    * When coordinaters are correct method return coordinates as array of int.

10. translateFromStringToCoordinates(String coordinatesAsString)
    * This method transforms coordinaters from String type to int array type.
    * The method returns array of int. 

11. getOcean()
    * This method returns ocean field.

12. getName()
    * This method returns name field.

13. setName(String name)
    * This method sets name field.
