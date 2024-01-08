import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task4 extends JFrame {
    private JLabel quizlbl;
    private JLabel timerlbl; 
    private JButton submitBtn;
    private JRadioButton[] choices;
    private int currentQuizIndex;
    private Timer timer;
    private int score;
   
    private String[] questions = {
            "<html><u>1) Of the following, if statements, which one correctly executes three instructions if the condition is true?</u></html>",
            "<html><u>2) _______ is the process of finding errors and fixing them within a program?</u></html>",
            "<html><u>3) During program development, software requirements specify?</u></html>",
            "<html><u>4) A loop that never ends is referred to as a(n)_________?</u></html>",
            "<html><u>5) Which command will stop an infinite loop?</u></html>"
    };
    private String[][] options = {
            {"If (x < 0) a = b * 2; y = x; z = a – y;","{ if (x < 0) a = b * 2; y = x; z = a – y; }","If{ (x < 0) a = b * 2; y = x; z = a – y ; }","If (x < 0) { a = b * 2; y = x; z = a – y; }"},
            {"Compiling", "Executing", "Debugging", "Scanning"},
            {"How the program will accomplish the task", "What the task is that the program must perform", "How to divide the task into subtasks", "How to test the program when it is done"},
            {"While loop","Infinite loop","Recursive loop","for loop"},
            {"Alt-C","Shift-C","Esc","Ctrl-C"}
    };
    private int[] correctAnswers = {4, 3, 2, 2, 4};

    public task4() {
        setTitle("Quiz Application with Timer");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(173, 216, 230));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        quizlbl = new JLabel();
        Font boldFont = new Font(quizlbl.getFont().getName(), Font.BOLD, 18);
        quizlbl.setFont(boldFont);
        add(quizlbl, BorderLayout.NORTH);
        JPanel optionpnl = new JPanel(new GridLayout(4, 1));
        choices = new JRadioButton[4];
        ButtonGroup btnGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            choices[i] = new JRadioButton();
            choices[i].setText(options[currentQuizIndex][i]);
            choices[i].setBackground(Color.LIGHT_GRAY);
            Font largerFont = new Font(choices[i].getFont().getName(), Font.PLAIN, 16); 
            choices[i].setFont(largerFont);
            btnGroup.add(choices[i]);
            optionpnl.add(choices[i]);
        }
        add(optionpnl, BorderLayout.CENTER);

        submitBtn = new JButton("Submit");
        submitBtn.setFont(boldFont);
        add(submitBtn, BorderLayout.SOUTH);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                displayNextQuestion();
            }
        });

        timerlbl = new JLabel();
        timerlbl.setFont(boldFont);
        add(timerlbl, BorderLayout.EAST);
        currentQuizIndex = 0;
        displayQuestion();
        startTimer();
    }

    private void displayQuestion() {
        quizlbl.setText(questions[currentQuizIndex]);
        for (int i = 0; i < 4 ; i++) {
            choices[i].setText(options[currentQuizIndex][i]);
            choices[i].setSelected(false);
        }
    }

    private void displayNextQuestion() {
        currentQuizIndex++;
        if (currentQuizIndex < questions.length) {
            displayQuestion();
            resetTimer();
        } else {
            showResult();
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() { 
            private int secondsLeft = 10; 
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft >= 0) {
                    timerlbl.setText("Time left: " + secondsLeft + " seconds");
                    secondsLeft--;
                } else {
                    timer.stop();
                    checkAnswer();
                    displayNextQuestion();
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (choices[i].isSelected() && (i+1) == correctAnswers[currentQuizIndex]) {
                score++;
            }
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Completed!\nScore: " + score + "/" + questions.length);
        System.exit(0);
    }

    private void resetTimer() {
        timer.stop();
        startTimer();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new task4().setVisible(true);
            }
        });
    }
}
