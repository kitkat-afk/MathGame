public class Tester {
    public static void main(String[] args)
    {
        MathGenerator t = new MathGenerator();

        t.generateEquation(100);
        for(int i = 0; i < 10; i++) {
            System.out.println(t.questionList[i].toString());
        }
    }
}