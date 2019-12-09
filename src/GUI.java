import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {
    // unique serial ID
    private static final long serialVersionUID = 890643356112344L;
    MathGenerator equation = new MathGenerator();
    Database d = new Database();
    Student stud; //user that will be logged into on the login screen
    Teacher teach;
    private int counter = 0;
    private int numberQuestions = 10;
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
     * This method resets the previous screen and displays the newSelection method.
     */
    private void jumpToNewScreen() {
        setVisible(false);
        dispose();
        newSelection();
        setVisible(true);
    }

    /**
     * This method resets the previous screen and displays the arithmeticScreen method, which start the arithmetic game.
     */
    private void jumpToArithmeticScreen() {
        setVisible(false);
        dispose();
        arithmeticSelection();
        setVisible(true);
    }

    private void jumpToLoadScreen(int stuOrTeach) {
        setVisible(false);
        dispose();
        loadScreen(stuOrTeach);
        setVisible(true);
    }

    /**
     * This method resets previous screen and displays the mathOrNumbersPlace method, which asks the user which game they wish to play.
     */
    private void jumpToMathOrNumbersPlace() {
        setVisible(false);
        dispose();
        mathOrNumbersPlace();
        setVisible(true);
    }

    /**
     * This method resets the previous screen and displays the endScreen method.
     */
    private void jumpToEndScreen() {
        setVisible(false);
        dispose();
        endScreen();
        setVisible(true);
    }

    private void jumpToShowStats() {
        setVisible(false);
        dispose();
        showStats();
        setVisible(true);
    }

    private void jumpToTeacherButtons(){
        setVisible(false);
        dispose();
        teacherButtons();
        setVisible(true);
    }

    private void jumpToDelete(){
        setVisible(false);
        dispose();
        deleteStudent();
        setVisible(true);
    }

    private void jumpToAdd(){
        setVisible(false);
        dispose();
        addStudent();
        setVisible(true);
    }

    private void jumpToView(){
        setVisible(false);
        dispose();
        view();
        setVisible(true);
    }

    /**
     * This class is the initial screen with the 'New', 'Load', and 'Quit' buttons.
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

        // Creates a label with the following string
        JLabel lblWelcomeToNumber = new JLabel("Welcome to Number Quest!");
        lblWelcomeToNumber.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        lblWelcomeToNumber.setBounds(70, 57, 576, 85);
        contentPane.add(lblWelcomeToNumber);


        // Creates a 'New' button on the initial screen
        JButton btnNew = new JButton("NEW");
        btnNew.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        // will jump to the new screen if the user clicks on the 'new' button
        btnNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToNewScreen();
            }
        });
        btnNew.setBackground(new Color(245, 245, 220));
        btnNew.setBounds(329, 206, 115, 29);
        contentPane.add(btnNew);


        // Creates a 'Load' button on the initial screen
        JButton btnLoad = new JButton("LOAD");
        btnLoad.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        // will jump to the screen asking if they want to play the arithmetic or finding the numbers place game if the user clicks on the 'load' button
        btnLoad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToLoadScreen(0);
            }
        });
        btnLoad.setBackground(new Color(245, 245, 220));
        btnLoad.setBounds(329, 273, 115, 29);
        contentPane.add(btnLoad);

        // Creates a 'Quit' button on the initial screen that exits out of the game
        JButton btnQuit = new JButton("QUIT");
        btnQuit.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        // adds an action to the quit button to exit whole game
        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(1);
                ;
            }
        });
        btnQuit.setBackground(new Color(245, 245, 220));
        btnQuit.setBounds(329, 344, 115, 29);
        contentPane.add(btnQuit);


        // Creates a button in the bottom right corner for teachers
        JButton btnStudentProfiles = new JButton("TEACHER");
        btnStudentProfiles.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        btnStudentProfiles.setBackground(new Color(245, 245, 245));
        btnStudentProfiles.setBounds(551, 344, 158, 29);
        btnStudentProfiles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpToLoadScreen(1);
            }
        });
        contentPane.add(btnStudentProfiles);
    }

    /**
     * This is the screen that will show if the user hits the 'New' button on the initial startup
     */
    public void newSelection() {
        final JPanel contentPane;
        // creates the main frame for the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 204));
        contentPane.setBorder(new LineBorder(new Color(102, 204, 204), 50, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // prompts the user to enter their first name in the text box
        JLabel lblEnterYourFirst = new JLabel("Enter your name:");
        lblEnterYourFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourFirst.setBounds(67, 96, 325, 34);
        contentPane.add(lblEnterYourFirst);

        // the text field that the user can enter their name
        final JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        textField.setBounds(77, 155, 286, 59);
        contentPane.add(textField);
        textField.setColumns(10);

        // prompts the user to enter their password in the text box
        JLabel lblEnterYourLast = new JLabel("Create your password:");
        lblEnterYourLast.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourLast.setBounds(67, 244, 325, 50);
        contentPane.add(lblEnterYourLast);

        // prompts the user to enter their password in the text box
        final JTextField textField_1 = new JTextField();
        textField_1.setBounds(78, 308, 285, 59);
        textField_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // creating a submit button for the user to submit their information
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        btnSubmit.setBounds(617, 377, 134, 44);
        contentPane.add(btnSubmit);
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = textField.getText();
                String password = textField_1.getText();
                if (d.newUser(username, password, 0)) {
                    JOptionPane.showMessageDialog(contentPane, "Created successfully!");
                    jumpToMathOrNumbersPlace();
                } else JOptionPane.showMessageDialog(contentPane, "Error.");
            }
        });

        // a back button that will go to the previous screen (which is the loginGUI - the one with New, Load, Quit page) method
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        // when user clicks on back button, it will load the initial
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                dispose();
                loginGUI();
                setVisible(true);
            }
        });
        btnNewButton.setBounds(41, 383, 170, 29);
        contentPane.add(btnNewButton);

        // label to prompt the user that this screen is to create an account
        JLabel lblLogin = new JLabel("CREATE AN ACCOUNT");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        lblLogin.setBounds(158, 36, 453, 44);
        contentPane.add(lblLogin);
    }

    /**
     * This method is the screen after the user clicks 'load'. It will prompt the user for their name and password that they already
     * created in the 'New' selection. It will load show their profile once they click the login button. Then it will prompt them to start
     * the game.
     */
    public void loadScreen(int stuOrTeach) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        final JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(224, 255, 255));
        contentPane.setBorder(new MatteBorder(25, 25, 25, 25, (Color) new Color(248, 248, 255)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // first name of user
        JLabel lblEnterYourFirst = new JLabel("Enter your first name:");
        lblEnterYourFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourFirst.setBounds(48, 91, 325, 34);
        contentPane.add(lblEnterYourFirst);

        // text field for user to enter name
        final JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        textField.setBounds(48, 155, 286, 59);
        contentPane.add(textField);
        textField.setColumns(10);

        // password of the user
        JLabel lblEnterYourLast = new JLabel("Enter your password:");
        lblEnterYourLast.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterYourLast.setBounds(48, 230, 286, 50);
        contentPane.add(lblEnterYourLast);

        // text field for user to enter the password
        final JTextField textField_1 = new JTextField();
        textField_1.setBounds(49, 308, 285, 59);
        textField_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // login button
        JButton btnSubmit = new JButton("Login");
        btnSubmit.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        btnSubmit.setBounds(617, 377, 134, 44);
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object result = null;
                String username = textField.getText().trim();
                String password = textField_1.getText().trim();
                System.out.print(username + " " + password);

                if(stuOrTeach == 0) {
                    result = (Student) d.login(username, password, stuOrTeach);
                }
                else
                    result = (Teacher) d.login(username,password,stuOrTeach);

                System.out.println(result);
                if (result != null && stuOrTeach == 0) {
                    stud = (Student)result;
                    jumpToMathOrNumbersPlace();
                }
                else if(result != null && stuOrTeach == 1) {
                    teach = (Teacher)result;
                    System.out.println("Teacher login completed.");
                    jumpToTeacherButtons();
                }
                else if (result == null) {
                    JOptionPane.showMessageDialog(contentPane, "Error: User not found.");
                }
            }
        });
        contentPane.add(btnSubmit);
        // back button in case they clicked the wrong button
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                dispose();
                loginGUI();
                setVisible(true);
            }
        });
        btnNewButton.setBounds(41, 383, 170, 29);
        contentPane.add(btnNewButton);

        // label to show this is the login screen
        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        lblLogin.setBounds(310, 36, 154, 44);
        contentPane.add(lblLogin);
    }


    /**
     * This method creates the 10 questions for the 'Arithmetic' button
     */
    public void arithmeticSelection() {
        final JPanel contentPane = new JPanel();
        final JTextField textField = new JTextField();
        final int i = 0;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new LineBorder(new Color(255, 255, 102), 50, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Showing user math problem
        JLabel lblProblem = new JLabel("What is " + equation.generateEquation(50, 10)[0].askQuestion() + " ?");
        lblProblem.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
        lblProblem.setBounds(65, 184, 443, 48);
        contentPane.add(lblProblem);

        // text field where user can answer the question
        textField.setBounds(523, 180, 125, 52);
        textField.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        contentPane.add(textField);
        textField.setColumns(10);

        // this shows the progress bar at the top of the screen and changes every time the user gets an answer correct
        final JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(270, 71, 238, 48);
        progressBar.setValue(numberCorrect * 10);
        progressBar.setStringPainted(true);
        contentPane.add(progressBar);

        // The submit button once the user answers the question to check if their answer is correct
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(551, 358, 170, 29);
        btnSubmit.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int num = numberCorrect;
                // this if, else statement checks if the user entered any numbers or if they entered a valid number
                if (textField.getText().length() == 0) {
                    checkIfEnteredAnything(contentPane, textField.getText());
                } else {
                    checkIfLegalNumber(contentPane, textField.getText());
                }

                // checking if the user input is correct or not
                if (equation.questionList[i].getSum() == Integer.parseInt(textField.getText())) {
                    JOptionPane.showMessageDialog(contentPane, "Right answer!");
                    num++;
                    numberCorrect = num;
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Wrong answer! The right answer was " + equation.questionList[i].getSum());
                }
                counter++;
                // setting new value of the progress bar
                progressBar.setValue(numberCorrect * 10);
                progressBar.setStringPainted(true);

                // if, else statement will continue asking questions until the user reaches 10 questions
                if (counter == numberQuestions) {
                    // will jump to the 'Game Over' screen if the user reaches 10 questions
                    stud.setAnsAttempt(counter);
                    stud.setAnsCorrect(numberCorrect);
                    d.updateStudent(stud);
                    jumpToEndScreen();
                } else {
                    jumpToArithmeticScreen();
                }
            }
        });
        btnSubmit.setBounds(551, 358, 170, 29);
        contentPane.add(btnSubmit);

        // Shows the pause selection on the screen which will eventually have two buttons, one for resuming the game or one for quitting the game
        JButton btnNewButton = new JButton("Pause");
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnNewButton.setBounds(57, 358, 170, 29);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                pauseScreen();
                setVisible(true);
            }
        });
        contentPane.add(btnNewButton);
    }

    /**
     * This method will show the screen for when students want to play the math game or if they want to play the game that shows the number place
     */
    private void mathOrNumbersPlace() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.RED);
        contentPane.setBorder(new LineBorder(Color.WHITE, 40, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // A button for the 'Numbers Place' that will generate a game recognize numbers
        JButton btnNumbers = new JButton("Numbers Place");
        btnNumbers.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnNumbers.setBounds(451, 167, 252, 120);
        contentPane.add(btnNumbers);

        // A button where if the user clicks on the button, it will generate the 10 math problems
        JButton btnArtithmetic = new JButton("Artithmetic");
        btnArtithmetic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToArithmeticScreen();
            }
        });
        btnArtithmetic.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnArtithmetic.setBounds(77, 167, 252, 120);
        contentPane.add(btnArtithmetic);


        // a back button that will go to the previous screen (which is the loginGUI) method
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 16));


        // when user clicks on button, it will load the page login page
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                dispose();
                loginGUI();
                setVisible(true);
            }
        });
        btnBack.setBounds(15, 399, 115, 29);
        contentPane.add(btnBack);
    }

    /**
     * This method is the screen when the user is finished with the game. It will say 'Game Over!' with their score and asking the user if they
     * want to play again or quit the game. Once the user reaches this screen, the database will update with the recent score.
     */
    private void endScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 204, 153));
        contentPane.setBorder(new MatteBorder(50, 50, 50, 50, (Color) new Color(153, 255, 204)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Shows the user the 'Game Over' text
        JLabel lblGameOver = new JLabel("GAME OVER! ");
        lblGameOver.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
        lblGameOver.setBounds(216, 50, 379, 125);
        contentPane.add(lblGameOver);

        // Tells the user how many they got right
        JLabel lblYouGotOut = new JLabel("You got " + numberCorrect + " out of " + numberQuestions + " correct!");
        lblYouGotOut.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblYouGotOut.setBounds(160, 225, 480, 58);
        contentPane.add(lblYouGotOut);
        JButton btnNext = new JButton("Next");
        btnNext.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnNext.setBounds(606, 358, 115, 29);
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToShowStats();
            }
        });
        contentPane.add(btnNext);
    }

    private void pauseScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setBorder(new LineBorder(new Color(255, 218, 185), 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPause = new JLabel("PAUSE");
        lblPause.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblPause.setBounds(153, 32, 117, 56);
        contentPane.add(lblPause);

        JButton btnResume = new JButton("Resume");
        btnResume.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
                jumpToArithmeticScreen();
            }
        });
        btnResume.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        btnResume.setBounds(155, 116, 115, 29);
        contentPane.add(btnResume);

        JButton btnQuit = new JButton("Quit");
        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpToEndScreen();
            }
        });
        btnQuit.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        btnQuit.setBounds(155, 173, 115, 29);
        contentPane.add(btnQuit);
        jumpToShowStats();
    }

    private void showStats() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(124, 252, 0));
        contentPane.setBorder(new LineBorder(new Color(32, 178, 170), 25, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("Here are your stats, " + stud.getName());
        lblName.setBounds(32, 32, 705, 57);
        lblName.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Total Correct: " + stud.getAnsCorrect() +"/" + stud.getAnsAttempt());
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblNewLabel.setBounds(32, 224, 705, 57);
        contentPane.add(lblNewLabel);

        JLabel lblAnswerCorrectIn = new JLabel("Answered Correct in this Round: " + numberCorrect);
        lblAnswerCorrectIn.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblAnswerCorrectIn.setBounds(32, 167, 705, 57);
        contentPane.add(lblAnswerCorrectIn);

        JLabel lblPercentageOfGame = new JLabel("Percentage of Game: " + stud.getTotal() + "%");
        lblPercentageOfGame.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblPercentageOfGame.setBounds(27, 278, 710, 57);
        contentPane.add(lblPercentageOfGame);

        // A quit button which will let the user quit the game
        JButton btnQuit = new JButton("Quit");
        btnQuit.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnQuit.setBounds(606, 358, 115, 29);
        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(1);
                ;
            }
        });
        contentPane.add(btnQuit);

        // A 'Play Again' button which will prompt them back to the mathOrNumbersPlaceScreen method
        JButton btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnPlayAgain.setBounds(56, 359, 138, 29);
        btnPlayAgain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                dispose();
                mathOrNumbersPlace();
                setVisible(true);
            }
        });
        contentPane.add(btnPlayAgain);

        JButton btnHome = new JButton("Home");
        btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                dispose();
                loginGUI();
                setVisible(true);
            }
        });

        btnHome.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnHome.setBounds(333, 359, 115, 29);
        contentPane.add(btnHome);

        counter = 0;
        numberCorrect = 0;

    }

    private void teacherButtons() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 25, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Delete Student");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpToDelete();
            }
        });
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnNewButton.setBounds(299, 223, 195, 40);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("View Students");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpToView();
            }
        });
        btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnNewButton_1.setBounds(299, 308, 195, 40);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Add Student");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToAdd();
            }
        });
        btnNewButton_2.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnNewButton_2.setBounds(299, 143, 195, 40);
        contentPane.add(btnNewButton_2);
        JLabel lblTeacherLogin = new JLabel("Teacher Login");
        lblTeacherLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        lblTeacherLogin.setBounds(58, 54, 317, 51);
        contentPane.add(lblTeacherLogin);

        JButton btnNewButton_3 = new JButton("Back");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                dispose();
                loginGUI();
                setVisible(true);
            }
        });
        btnNewButton_3.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnNewButton_3.setBounds(31, 385, 115, 29);
        contentPane.add(btnNewButton_3);
    }


    public void deleteStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 182, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Delete Students");
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
        lblNewLabel.setBounds(15, 16, 410, 77);
        contentPane.add(lblNewLabel);

        JLabel lblEnterTheStudents = new JLabel("Enter the student's name:");
        lblEnterTheStudents.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnterTheStudents.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblEnterTheStudents.setBounds(201, 112, 389, 67);
        contentPane.add(lblEnterTheStudents);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        textField.setBounds(222, 195, 357, 54);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(d.deleteStudent(textField.getText().trim()))
                    JOptionPane.showMessageDialog(contentPane, "Deleted successfully!");
                else
                    JOptionPane.showMessageDialog(contentPane, "Error: User does not exist.");
            }
        });
        btnDelete.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        btnDelete.setBounds(304, 293, 195, 43);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpToTeacherButtons();
            }
        });
        btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        btnBack.setBounds(15, 399, 115, 29);
        contentPane.add(btnBack);
    }


     private void addStudent() {
         final JPanel contentPane;
         // creates the main frame for the screen
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 800, 500);
         contentPane = new JPanel();
         contentPane.setBackground(new Color(204, 153, 204));
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);

         // prompts the user to enter their first name in the text box
         JLabel lblEnterYourFirst = new JLabel("Enter student name:");
         lblEnterYourFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
         lblEnterYourFirst.setBounds(67, 96, 325, 34);
         contentPane.add(lblEnterYourFirst);

         // the text field that the user can enter their name
         final JTextField textField = new JTextField();
         textField.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
         textField.setBounds(77, 155, 286, 59);
         contentPane.add(textField);
         textField.setColumns(10);

         // prompts the user to enter their password in the text box
         JLabel lblEnterYourLast = new JLabel("Create their password:");
         lblEnterYourLast.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
         lblEnterYourLast.setBounds(67, 244, 325, 50);
         contentPane.add(lblEnterYourLast);

         // prompts the user to enter their password in the text box
         final JTextField textField_1 = new JTextField();
         textField_1.setBounds(78, 308, 285, 59);
         textField_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
         contentPane.add(textField_1);
         textField_1.setColumns(10);

         // creating a submit button for the user to submit their information
         JButton btnSubmit = new JButton("Submit");
         btnSubmit.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
         btnSubmit.setBounds(617, 377, 134, 44);
         contentPane.add(btnSubmit);
         btnSubmit.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 String username = textField.getText();
                 String password = textField_1.getText();
                 if (d.newUser(username, password, 0)) {
                     JOptionPane.showMessageDialog(contentPane, "Created successfully!");
                 } else JOptionPane.showMessageDialog(contentPane, "Error.");
             }
         });

         // a back button that will go to the previous screen (which is the loginGUI - the one with New, Load, Quit page) method
         JButton btnNewButton = new JButton("Back");
         btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
         // when user clicks on back button, it will load the initial
         btnNewButton.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent arg0) {
                 setVisible(false);
                 dispose();
                 jumpToTeacherButtons();
                 setVisible(true);
             }
         });
         btnNewButton.setBounds(41, 383, 170, 29);
         contentPane.add(btnNewButton);

         // label to prompt the user that this screen is to create an account
         JLabel lblLogin = new JLabel("Add a Student");
         lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
         lblLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 35));
         lblLogin.setBounds(158, 36, 453, 44);
         contentPane.add(lblLogin);
     }

    public void view() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 196));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblViewStudents = new JLabel("View Students");
        lblViewStudents.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
        lblViewStudents.setBounds(15, 16, 210, 47);
        contentPane.add(lblViewStudents);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBounds(10, 88, 758, 346);
        JLabel data = new JLabel(d.printAllStudents());
        data.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        data.setVerticalAlignment(SwingConstants.TOP);
        scrollPane.add(data);
        contentPane.add(scrollPane);


        JButton btnBack = new JButton("Back");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                jumpToTeacherButtons();
            }
        });
        btnBack.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        btnBack.setBounds(648, 16, 115, 29);
        contentPane.add(btnBack);

    }


        /**
         * This method checks if the user left the text box blank. It will catch an Illegal argument exception with a message box.
         *
         * @param contentPane The current JPanel
         * @param input       The input that the user entered
         */
    private void checkIfEnteredAnything(JPanel contentPane, String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a value. Try again.");
        }
    }

    /**
     * This method checks if the user enters a number that is too big to fit an integer or if they accidentally did not enter a number.
     * It will catch an Illegal argument exception with a message box.
     *
     * @param contentPane The current JPanel
     * @param input       The input that the user entered
     */
    private void checkIfLegalNumber(JPanel contentPane, String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(contentPane, "That is out of bounds or not a number. Try again.");
        }
    }

}
