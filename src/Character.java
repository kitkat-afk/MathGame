
/**
 * This class creates an account if you are a student or teacher. So far, it is mainly adjusted if you were a student.
 * Will work on teacher later.
 */
 public class Account {
    public static int totalHP;
    public static String name, characterChoice, username;
    com.company.Database d = new com.company.Database();

    /**
     * Constructor used when creating a brand-new user, for use in Database
     * @param name (user)name of the player
     */
    public Account(String name) {
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
        if (d.files.contains(username)) {
            while (d.files.contains(username)) {
                username = name + counter;
                counter++;
            }
        }
    }

    // getter for character choice
    public String getCharacterChoice() {
        return characterChoice;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for HP points
    public  int getTotalHP() {
        return totalHP;
    }

    // getter for username
    public String getUsername() {
        return username;
    }

    public void takeDamage(int damageTaken)
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

