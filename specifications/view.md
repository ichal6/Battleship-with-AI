__[back to README](../README.md)__

# Description
This class is used to view a board game. 

# Fields
This class doesn't contain fields.

# Methods
1. printOcean(Ocean currentOcean, Game currentGame)
    * This method prints currentOcean to terminal.
    * It gets two parameters:
        * currentOcean is a type of Ocean class.
        * hasGameStarted, a boolean.
    
2. inputFromUser(String textToView)
    * This method gets input from a user from stdin.
    * It gets one parameter:
        * textToView is a type of a String. This a String will be display in terminal before it will be get input from user.
    * The method returns a String with a user's answer.

3. clearScreen()
    * This method clears the terminal.

4. printPossibleShips(HashMap<String, Integer> possibleShips)
    * This method is used to print elements of Hashmap possibleShips.

5. printTitle(String title)
    * This method prints String title in title format.
    
6. printText(String text)
    * This method prints text in normal format.
    * Can be used to display validation information, hit/miss/won/lost messages etc.
    