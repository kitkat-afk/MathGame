public class Character {
    public static int totalHP;
    public static String name, characterChoice;

    //include standard get/set methods and a constructor.
    //other methods as needed will be added.

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
}
