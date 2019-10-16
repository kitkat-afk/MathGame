public class Enemy {
    public String enemy_type;
    public int totalHP;
    private MathGenerator m;
    public MathObject[] questionList;
    private final int EASY = 10, MED = 51, HARD = 100;


    public Enemy(int HP, String enemy, int difficulty)
    {

        totalHP = HP;
        enemy_type = enemy;
        m = new MathGenerator();
        //monster has 50 HP, each question does 10 points of damage

        if(difficulty == 0)
            difficulty = EASY;
        else if (difficulty == 1)
            difficulty = MED;
        else
            difficulty = HARD;

        this.questionList = m.generateEquation(difficulty, 10);
    }

    public int getTotalHP() {
        return totalHP;
    }

    public void takeDamage (int damageTaken)
    {
        totalHP -= damageTaken;
    }
}
