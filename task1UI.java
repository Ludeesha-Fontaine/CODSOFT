import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class task1UI implements ActionListener{
    JButton btn_check, btn_clear, btn_exit;
    JTextField txt_nmbr;

     //declaring variables
     double userGuess, RandomResult;

     //set maximum value as 50
     final int maxValue = 50;

     //set number of attempts
     int numberOfAttempts, score = 0;
     int maxAttempts = 3;

    task1UI(){
        JFrame f = new JFrame("Generate_Random");
        JPanel p = new JPanel(null);
        btn_check = new JButton("CHECK");
        btn_clear = new JButton("CLEAR");
        btn_exit = new JButton("EXIT");
        JLabel lbl_1 = new JLabel("Enter a number between 0 and 50: ");
        JLabel lbl_2 = new JLabel("Welcome to the Number Game..");
        JLabel lbl_3 = new JLabel("Game Rules:..There is only 1 Game Round and a round consists of 3 attempts.");
        JLabel lbl_4 = new JLabel("Status");
        txt_nmbr = new JTextField();
        txt_nmbr.setEditable(true);
        btn_check.addActionListener(this);
        btn_clear.addActionListener(this);
        btn_exit.addActionListener(this);

        f.setVisible(true);
        f.setSize(500,400);
        f.setLocationRelativeTo(null);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(btn_check);
        p.add(btn_clear);
        p.add(btn_exit);
        p.add(lbl_1);
        p.add(lbl_2);
        p.add(lbl_3);
        p.add(lbl_4);
        p.add(txt_nmbr);

        lbl_2.setBounds(150, 20, 260, 20);
        lbl_3.setBounds(15, 60, 480, 20);
        lbl_1.setBounds(50, 150, 200, 20);
        txt_nmbr.setBounds(250, 150, 140, 20);
        btn_check.setBounds(40, 250, 100, 30);
        btn_clear.setBounds(180, 250, 100, 30);
        btn_exit.setBounds(320, 250, 100, 30);
        lbl_4.setBounds(150, 350, 200, 30);

    
    }
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btn_check){
                checkGuess();
            }
            if(e.getSource() == btn_clear){
                txt_nmbr.setText("");
            }
            if(e.getSource() == btn_exit){
                System.exit(0);
            }
        }

        void checkGuess(){

            //random instance
            Random randValue = new Random();

            //set next random value
            RandomResult = randValue.nextInt(maxValue)+1;
            
            //guess a value by user
            userGuess = Double.parseDouble(txt_nmbr.getText());
            numberOfAttempts++;

            //if the guessed value is greater than random result
            if(userGuess > RandomResult){
                JOptionPane.showMessageDialog(null,"Your guess is Too High,.Try again..");

            //if the guessed value is less than random result
            }else if(userGuess < RandomResult){
                JOptionPane.showMessageDialog(null,"Your guess is Too Low, Try again..");

            //if the guessed value is equal to random result    
            }else{
                JOptionPane.showMessageDialog(null,"Congratulations, you guessed the number..");
                score++;
            }
            if (numberOfAttempts < maxAttempts) {
                txt_nmbr.setText("");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Sorry!..You ran out of guesses. The correct number was "+RandomResult);
                showScore();
            }
        }

        private void showScore() {
            JOptionPane.showMessageDialog(null, "Your FINAL SCORE is: " + score);
        }

        public static void main(String[] args) {
            new task1UI();
        }
}
