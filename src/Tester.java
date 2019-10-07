public class Tester {
    public static void main(String[] args)
    {
        MathGenerator t = new MathGenerator();

        t.easyEquations();

        for(int i = 0; i < t.questionList.length; i++)
            System.out.println(t.questionList[i]);

        t.mediumEquations();

        for(int i = 0; i < t.questionList.length; i++)
            System.out.println(t.questionList[i]);

        t.hardEquations();

        for(int i = 0; i < t.questionList.length; i++)
            System.out.println(t.questionList[i]);
    }
}