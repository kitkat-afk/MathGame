public class Character {
    public static int totalHP;
    public static String name, characterChoice;


    //include standard get/set methods and a constructor.
    //other methods as needed will be added.


    /**
     * Constructor used when creating a brand-new user, for use in Database
     * @param player_name (user)name of the player
     */
    public Character(String player_name)
    {
        this(0,player_name,"dragon");
    }

    /**
     *
     * @param difficulty the desired difficulty of the game (0-2), defaults to 2 if unexpected input
     * @param player_name (user)name of player
     * @param character character choice of the player (dragon, cat, bear)
     */
    public Character(int difficulty, String player_name, String character)
    {
        if(difficulty == 0)
            totalHP = 150;
        else if(difficulty == 1)
            totalHP =  100;
        else if(difficulty == 2)
            totalHP = 50;
        else
            totalHP = 0;

        name = player_name;
        characterChoice = character;
    }

    public static String getCharacterChoice() {
        return characterChoice;
    }

    public static String getName() {
        return name;
    }

    public static int getTotalHP() {
        return totalHP;
    }

    public static void setCharacterChoice(String characterChoice) {
        Character.characterChoice = characterChoice;
    }

    public static void setTotalHP(int totalHP) {
        Character.totalHP = totalHP;
    }

    public static void setName(String name) {
        Character.name = name;
    }

    public void takeDamage(int damageTaken)
    {
        totalHP -= damageTaken;
    }

}
