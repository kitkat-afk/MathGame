import java.lang.Math;
import java.util.Scanner;

public class MathGenerator {
    private static int[] easy = new int[3];
    private static int[] medium = new int[3];
    private static int[] hard = new int[3];
    private int answer;
    public static int questions = 10;

    public MathObject[] questionList = new MathObject[questions];
    //array of questions to fill out

    // constructor
    public MathGenerator() {

    }

   /*
    /*
     *Depreciated while working on database
     *
     *
     * This method keeps score of the game. It will record the number of questions
     * correct and also the total percentage they got right so far. It also shifts
     * the number of questions until they get 10 right total.
     *
     * @param input The user's answer to the questions
     * @return The total score

    public static int keepScore(int input) {
        int score = 0;
        int total = 0;

        for (int i = 0; i <= questions; i++) {
            // when they lose, it will break the loop
            if (questions == 0) {
                break;
            }

            // score increases if right, but decreases if wrong
            if (correctAnswer(input) == true) {
                score++;
            } else {
                score--;
                questions--;
            }

            // total percentage
            total = (score / questions);
            // telling them what their score is out of the number of questions asked
            System.out.println("Current score is: " + score + "/" + questions);
        }
        return total;
    }
    */

    /*
     * This method creates easier equations, adding and subtracting numbers between
     * 0 and 20. It will enter a for loop, until it reaches the number of questions.
     * It stores the values into an array, for later use for checking if the
     * student's input matches the computer.
     *
     */

    public void easyEquations() {
        for (int i = 0; i < questions; i++) {
            int value1 = (int) (Math.random() * 21);
            // so that when subtracting, it does not become negative;
            int value2 = (int) (Math.random() * 20);

            // tells if plus or minus sign
            int value3 = (int) (Math.random() * 2);
            if (value3 == 0) {
                answer = value1 + value2;
            } else {
                answer = value1 - value2;
            }

            questionList[i] = new MathObject(value1, value3, value2, answer);
        }
    }

    /**
     * This method does the same as the above method, except it will have random
     * numbers from 20-60.
     */
    public void mediumEquations() {
        for (int i = 0; i < questions; i++) {
            int value1 = (int) (Math.random() * 61 + 20);
            // so that when subtracting, it does not become negative;
            int value2 = (int) (Math.random() * 50 + 20);
            // tells if plus or minus sign
            int value3 = (int) (Math.random() * 2);

            if (value3 == 0) {
                answer = value1 + value2;
            } else {
                answer = value1 - value2;
            }

            // adding values into an array
            questionList[i] = new MathObject(value1, value3, value2, answer);
        }
    }

    /**
     * This method does the same as the above method, except it will have random
     * numbers from 60-100.
     */
    public void hardEquations() {
        for (int i = 0; i < questions; i++) {
            int value1 = (int) (Math.random() * 101 + 60);
            // so that when subtracting, it does not become negative;
            int value2 = (int) (Math.random() * 100 + 60) - value1;
            // tells if plus or minus sign
            int value3 = (int) (Math.random() * 2);

            if (value3 == 0) {
                answer = value1 + value2;
            } else {
                answer = value1 - value2;
            }

            // adding values into an array
            questionList[i] = new MathObject(value1, value3, value2, answer);
        }
    }

    /**
     * This method checks to see if the student's answer is correct or not.
     *
     * @param input The student's answer
     * @return True if the answer is correct, false if it is not
     */
    public static boolean correctAnswer(int input) {
        if (easy[2] == input || medium[2] == input || hard[2] == input) {
            return true;
        }
        return false;
    }

    /**
     * This allows the teacher to input their own math problems if they wish.
     * @return
     */
    //public static int[] teacherAddOns() {

    //}


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