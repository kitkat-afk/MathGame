public class MathObject {
    private int one, two, sum, op;
    //if the operand is plus, set as 0, else, set as one.

    public MathObject(digitOne, operand, digitTwo, result)
    {
        one = digitOne;
        op = operand;
        two = digitTwo;
        sum = result;
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
        if(op == )
            return "+";
        else
            retur "-";
    }
}