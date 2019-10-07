import javax.swing.*;
import java.awt.*;

public class UITest extends JFrame {
    JButton opt1, opt2, opt3, opt4;
    JFrame fr;
    FlowLayout fl;




    public static void main(String args[]) {
        JFrame f = new JFrame("Test Framge");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        JButton opt1 = new JButton("Option 1");
        JButton opt2 = new JButton("Option 2");
        JButton opt3 = new JButton("Option 3");
        JButton opt4 = new JButton("Option 4");

        FlowLayout e = new FlowLayout();
        f.setLayout(e);

        f.getContentPane().add(opt1);
        f.getContentPane().add(opt2);
        f.getContentPane().add(opt3);
        f.getContentPane().add(opt4);

        f.setVisible(true);
    }
}
