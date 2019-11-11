import java.util.Scanner;

public class Main {
    //main class that runs the program.
    MathGenerator m;
    Account c;
   // Database db;
    Scanner scan;
    Enemy e;


    // 0 - easy 1- medium 2- hard
    int difficulty;

    public Main()
    {
        m = new MathGenerator();
       // db = new Database();
        scan = new Scanner(System.in);

        System.out.println("Welcome to Math Game v. 0.1!");

        System.out.print("Please enter your name :: ");
        String name = scan.nextLine();

        System.out.print("Please enter the difficulty (0, 1, 2) :: ");
        int diff = scan.nextInt();

        scan.nextLine();

        System.out.print("Please select a character (dragon, cat, bear) :: ");
        String chara = scan.nextLine();


        c = new Account(diff, name, chara);

        e = new Enemy(50, "GhostOne",diff);

        attackEnemy(e.questionList);

    }

    public void attackEnemy(MathObject[] questions)
    {
        int response = 0;

        for(int i = 0; i < questions.length; i++)
        {
            System.out.println("What is " + questions[i].getOne() + " " + questions[i].getOp() + " " + questions[i].getTwo() + " ?");
            response = scan.nextInt();


            if(response == questions[i].getSum()) {
                System.out.println("Correct.");
                continue;
            }
            else
            {
                System.out.println("Incorrect. The correct answer was: " + questions[i].getSum());
                questions[i].setAnswerCorrect(false);
                c.takeDamage(25);

                if(c.getTotalHP() <= 0 ) {
                    System.out.println("Game Over.");
                    break;
                }
            }
        }
    }

    public void enemyAttack()
    {

    }


}
