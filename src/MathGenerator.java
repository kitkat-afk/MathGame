import java.lang.Math;

public class MathGenerator {
    public static int questions = 10;
    public MathObject[] questionList;
    private int value1, value2;
    //array of questions to fill out

    // constructor
    public MathGenerator() {
    }


    /**
     * Method that generates a set number of problems (default: 10) and saves them to an array of MathObjects.
     * Numbers will be randomly generated between 0 and the given limit. For subtraction, first number will
     * always be larger to prevent negative numbers.
     *
     * @param highBound the largest number allowed to be generated, exclusive
     */
    public MathObject[] generateEquation(int highBound, int numQuestions) {
        questionList = new MathObject[questions];

        for (int i = 0; i < numQuestions; i++) {
            value1 = (int) Math.abs(Math.random() * highBound);
            value2 = (int) Math.abs(Math.random() * highBound);

            int operand = (int) Math.abs(Math.random() * 2);
            //0 == add, 1 == subtract

            int answer = 0;


            //add
            if (operand == 0) {
                answer = value1 + value2;
                questionList[i] = new MathObject(value1, operand, value2, answer);
            } else {
                if (value2 > value1) {
                    int temp = value2;
                    value2 = value1;
                    value1 = temp;
                }

                answer = value1 - value2;
                questionList[i] = new MathObject(value1, operand, value2, answer);
            }
        }

        return questionList;
    }

    public MathObject[] generatePlacesQuestions() {
        questionList = new MathObject[questions];
        int place;

        for (int i = 0; i < questions; i++) {
            value1 = (int) Math.abs(Math.random() * 10);
            value2 = (int) Math.abs(Math.random() * 10);
            place = (int) Math.abs(Math.random() * 2); //0 for ones, 1 for tens

            questionList[i] = new MathObject(value1, value2, place);
        }

        return questionList;
    }

}

