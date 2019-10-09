import java.lang.Math;
import java.util.Scanner;

public class MathGenerator {
    public static int questions = 10;
    private int value1, value2;
    public MathObject[] questionList = new MathObject[questions];
    //array of questions to fill out

    // constructor
    public MathGenerator() {

    }


    /**
     * Method that generates a set number of problems (default: 10) and saves them to an array of MathObjects.
     * Numbers will be randomly generated between 0 and the given limit. For subtraction, first number will
     * always be larger to prevent negative numbers.
     * @param highBound the largest number allowed to be generated, exclusive
     */
    public void generateEquation(int highBound)
    {
        for(int i = 0; i < questions; i++)
        {
            value1 = (int)Math.abs(Math.random() * highBound);
            value2 = (int)Math.abs(Math.random() * highBound);

            int operand = (int)Math.abs(Math.random()*2);
            //0 == add, 1 == subtract

            int answer = 0;


            //add
            if(operand == 0)
            {
                answer = value1 + value2;
                questionList[i] = new MathObject(value1, operand, value2, answer);
            }
            else
            {
                if(value2 > value1)
                {
                    int temp = value2;
                    value2 = value1;
                    value1 = temp;
                }

                answer = value1 - value2;
                questionList[i] = new MathObject(value1, operand, value2, answer);
            }
        }
    }

    
    /**
     * This allows the teacher to input their own math problems if they wish.
     * @return
     */
    public static int[] teacherAddOns() {
        // TODO: 10/7/2019
        return null;
    }


    /**
     //main method
     public static void main(String[] args) {
     MathGenerator math = new MathGenerator();
     System.out.println("Hello! Welcome to the Math Games!");
     Scanner scan = new Scanner(System.in);
     int num = 0;
     String input = " ";
     do {
     System.out.println("Press 1 if you are a student, or 2 if you are a teacher.");
     num = scan.nextInt();
     if (num == 1) {
     System.out.println("What is your name?");
     input = scan.nextLine();
     Student student = new Student(input);
     System.out.println("Okay, " + input + ". Let's start.");
     } else if (num == 2) {
     Teacher teacher = new Teacher ();
     System.out.println("Would you like to add some math problems? (Y/N)");
     input = scan.nextLine();
     input.toUpperCase();
     if (input == "Y") {
     math.teacherAddOns();
     } else {
     System.out.println("This is the student's current score.");
     // need to code by being able to look at every student's scores.
     }
     } else {

     }
     } while (num == 1 || num == 2);
     }
     **/
}


// need to be able to code for the teacher to look at the student's scores
// need to be able to add math problems to the system