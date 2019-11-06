/**
 * This class creates an account if you are a student or teacher. So far, it is mainly adjusted if you were a student.
 * Will work on teacher later.
 *
 * THIS CLASS HAS BEEN DEPRECIATED. PLEASE USE Account_a INSTEAD.
 */
public class Account {
    public static int totalHP, ansCorrect, ansAttempt; //records attempted answers and total answers
    public static String name, characterChoice, username, password; //name, username, password,

    public Account(String name){ //what character they're using
        //Database d = new Database(); //database call

        /**
         * Constructor used when creating a brand-new user, for use in Database
         * @param name (user)name of the player
         */
        this.name = name;
    }

    /**
     * This is a second constructor for the user to create an account.
     *
     * @param difficulty the desired difficulty of the game (0-2), defaults to 2 if unexpected input
     * @param name (user)name of player
     * @param characterChoice character choice of the player (dragon, cat, bear)
     */
    public Account(int difficulty, String name, String characterChoice)
    {
        if(difficulty == 0)
            totalHP = 150;
        else if(difficulty == 1)
            totalHP =  100;
        else if(difficulty == 2)
            totalHP = 50;
        else
            totalHP = 0;

        this.name = name;
        this.characterChoice = characterChoice;
    }

    // setter for character
    public void setCharacterChoice(String characterChoice) {
        this.characterChoice = characterChoice;
    }

    // setter for HP points
    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // setter for username
    public void setUserName(String username) {
        int counter = 1;

        //checking if the arraylist contains the username
        //if (d.files.contains(username)) {
          //  while (d.files.contains(username)) {
            //    username = name + counter;
              //  counter++;
            //}
        //}
    }

    // getter for character choice
    public static String getCharacterChoice() {
        return characterChoice;
    }

    // getter for name
    public static String getName() {
        return name;
    }

    // getter for HP points
    public static int getTotalHP() {
        return totalHP;
    }

    // getter for username
    public static String getUsername() {
        return username;
    }

    public static void takeDamage(int damageTaken)
    {
        totalHP -= damageTaken;
    }

    /**
     * This prints out the string to be written in the file.
     * @return      The format of the student account
     */
    @Override
    public String toString() {
        return ("Name:" + getName() + "\n" + "Username:" + getUsername() + "\n" + "Character Choice: " +getCharacterChoice() + "\n" + "Total HP: " + getTotalHP());
    }

}


