public class Tester {
    public static void main(String[] args)
    {
        Main m = new Main();

        System.out.println("Char health: " + Account.getTotalHP());
        System.out.println("Char name: " + Account.getName());
        System.out.println("Char type: " + Account.getCharacterChoice());
    }
}