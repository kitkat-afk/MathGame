public class MathObject {
    private int one, two, sum, op;
    private boolean answerCorrect;
    //if the operand is plus, set as 0, else, set as one.

    public MathObject(int digitOne, int operand, int digitTwo, int result)
    {
        one = digitOne;
        op = operand;
        two = digitTwo;
        sum = result;
        answerCorrect = true;
    }

    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public int getSum() {
        return sum;
    }

    public String getOp() {
        if(op == 0)
            return "+";
        else
            return "-";
    }

    public boolean isAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(boolean tf)
    {
        answerCorrect = tf;
    }

    @Override
    public String toString()
    {
        return(one + " " + getOp() + " " + two + " = " );
    }
}