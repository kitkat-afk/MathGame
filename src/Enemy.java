public class Enemy {
    public String enemy_type;
    public int totalHP;
    private MathGenerator m;
    public MathObject[] questionList;
    public final int EASY = 10, MED = 51, HARD = 100;


    public Enemy(int HP, String enemy)
    {
        totalHP = HP;
        enemy_type = enemy;
        m = new MathGenerator();
        //monster has 50 HP, each question does 10 points of damage
        questionList = m.generateEquation();
    }

    public int getTotalHP() {
        return totalHP;
    }

    public void takeDamage (int damageTaken)
    {
        totalHP -= damageTaken;
    }
}
