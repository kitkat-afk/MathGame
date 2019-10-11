public class Tester {
    public static void main(String[] args)
    {
        Main m = new Main();

        MathGenerator t = new MathGenerator();

        t.generateEquation(100);
        for(int i = 0; i < 10; i++) {
            System.out.println(t.questionList[i].toString());
        }

        System.out.println("Char health: " + Character.getTotalHP());
        System.out.println("Char type: " + Character.getName());
        System.out.println("Char name: " + Character.getCharacterChoice());
    }
}