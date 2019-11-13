
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {
    private static final long serialVersionUID =  890643356112344L;
    MathGenerator equation = new MathGenerator();
    private int counter = 0;
    private Main main;
    private int numberQuestions = 0;
    private int numberCorrect = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.loginGUI();
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
    public void loginGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(147, 112, 219));
        contentPane.setForeground(new Color(240, 248, 255));
        contentPane.setBorder(new MatteBorder(50, 50, 50, 50, (Color) new Color(255, 228, 225)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblWelcomeToNumber = new JLabel("Welcome to Number Quest!");
        lblWelcomeToNumber.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        lblWelcomeToNumber.setBounds(70, 57, 576, 85);
        contentPane.add(lblWelcomeToNumber);

        JButton btnNew = new JButton("NEW");
        btnNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToNewScreen();
            }
        });
        btnNew.setBackground(new Color(245, 245, 220));
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNew.setBounds(329, 206, 115, 29);
        contentPane.add(btnNew);

        JButton btnLoad = new JButton("LOAD");
        btnLoad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToLoadScreen();
            }
        });
        btnLoad.setBackground(new Color(245, 245, 220));
        btnLoad.setBounds(329, 273, 115, 29);
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(btnLoad);

        JButton btnQuit  = new JButton("QUIT");
        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(1);;
            }
        });
        btnQuit.setBackground(new Color(245, 245, 220));
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnQuit.setBounds(329, 344, 115, 29);
        contentPane.add(btnQuit);

        JButton btnStudentProfiles = new JButton("Student Profiles");
        btnStudentProfiles.setBackground(new Color(245, 245, 245));
        btnStudentProfiles.setBounds(551, 344, 158, 29);
        contentPane.add(btnStudentProfiles);
    }

    public void newSelection() {
        JPanel contentPane;
        JTextField textField;
        JLabel lblEnterYourLast;
        JTextField textField_1;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 204));
        contentPane.setBorder(new LineBorder(new Color(102, 204, 204), 50, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEnterYourFirst = new JLabel("Enter your first name:");
        lblEnterYourFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourFirst.setBounds(78, 51, 325, 34);
        contentPane.add(lblEnterYourFirst);

        textField = new JTextField();
        textField.setBounds(77, 114, 286, 59);
        contentPane.add(textField);
        textField.setColumns(10);

        lblEnterYourLast = new JLabel("Enter a password:");
        lblEnterYourLast.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourLast.setBounds(78, 189, 286, 50);
        contentPane.add(lblEnterYourLast);

        textField_1 = new JTextField();
        textField_1.setBounds(78, 255, 285, 59);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSubmit.setBounds(568, 361, 134, 44);
        contentPane.add(btnSubmit);
    }


    private void jumpToNewScreen() {
        setVisible(false);
        dispose();
        newSelection();
        setVisible(true);
    }

    public void loadSelection() {
        final JPanel contentPane = new JPanel();
        final JTextField textField = new JTextField();
        final int i = 0;
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 800, 500);
            //contentPane = new JPanel();
            contentPane.setBackground(new Color(255, 255, 204));
            contentPane.setBorder(new LineBorder(new Color(255, 255, 102), 50, true));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblProblem = new JLabel("What is " + equation.generateEquation(50, 10)[0].askQuestion() + " ?");
            lblProblem.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
            lblProblem.setBounds(65, 184, 443, 48);
            contentPane.add(lblProblem);

            //textField = new JTextField();
            textField.setBounds(523, 180, 125, 52);
            contentPane.add(textField);
            textField.setColumns(10);

            JButton btnSubmit = new JButton("Submit");

            JProgressBar progressBar = new JProgressBar();
            progressBar.setBounds(270, 54, 238, 48);
            contentPane.add(progressBar);


            btnSubmit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    if (equation.questionList[i].getSum() == Integer.parseInt(textField.getText())) {
                        JOptionPane.showMessageDialog(contentPane, "Right answer");

                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Wrong answer");
                    }
                }
            });
            btnSubmit.setBounds(603, 354, 115, 29);
            contentPane.add(btnSubmit);
        }


    private void jumpToLoadScreen() {
            setVisible(false);
            dispose();
            loadSelection();
            setVisible(true);
        }

    private void showProgress() {

    }


}
