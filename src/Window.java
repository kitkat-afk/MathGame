import javax.swing.*;
import java.awt.*;

public class Window {
    public Window(int w, int h, String t, Game g)
    {
        JFrame f = new JFrame(t);

        f.setPreferredSize(new Dimension(w,h));
        f.setMaximumSize(new Dimension(w,h));
        f.setMinimumSize(new Dimension(w,h));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.add(g);
        f.setVisible(true);
        g.start();
    }
}
