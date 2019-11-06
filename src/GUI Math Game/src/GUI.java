import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Canvas;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUI() {
        setForeground(new Color(255, 255, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(221, 160, 221));
        contentPane.setBorder(new MatteBorder(25, 25, 25, 25, (Color) new Color(255, 240, 245)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Title = new JLabel("Welcome to Number Quest!");
        Title.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        Title.setBounds(114, 33, 566, 75);
        contentPane.add(Title);

        JButton btnNew = new JButton("NEW");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

            }
        });
        btnNew.setForeground(new Color(123, 104, 238));
        btnNew.setBackground(new Color(255, 255, 240));
        btnNew.setBounds(328, 184, 115, 29);
        contentPane.add(btnNew);

        JButton btnLoad = new JButton("LOAD");
        btnLoad.setForeground(new Color(165, 42, 42));
        btnLoad.setBackground(new Color(255, 255, 240));
        btnLoad.setBounds(328, 256, 115, 29);
        contentPane.add(btnLoad);

        JButton btnQuit = new JButton("QUIT");
        btnQuit.setBackground(new Color(255, 255, 240));
        btnQuit.setForeground(Color.BLACK);
        btnQuit.setBounds(328, 318, 115, 29);
        contentPane.add(btnQuit);

        JButton btnStudentProfiles = new JButton("STUDENT PROFILES");
        btnStudentProfiles.setForeground(new Color(176, 196, 222));
        btnStudentProfiles.setBackground(new Color(255, 255, 240));
        btnStudentProfiles.setBounds(545, 386, 203, 29);
        contentPane.add(btnStudentProfiles);

        JLabel label = DefaultComponentFactory.getInstance().createLabel("");
        label.setBounds(83, 301, 138, 20);
        contentPane.add(label);
    }

    private void jump2Game(JLabel label) {
        contentPane.setVisible(false);
        dispose();
        String welcome = "Pick a character, " + Account.name;
        Main.switchToGame();
    }
}
