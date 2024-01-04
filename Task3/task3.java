import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class savingsAccount{
    double balance;
    public savingsAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void deposit(double depositedAmount) {
        balance += depositedAmount;
    }
    public double getBalance() {
        return balance;
    }
    public boolean withdraw(double withdrwalAmount) {
        if (withdrwalAmount <= balance) {
            balance -= withdrwalAmount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private savingsAccount account;

    public ATM(savingsAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public boolean withdraw(double amount) {
        return account.withdraw(amount);
    }

    public double checkBalance() {
        return account.getBalance();
    }
}
class task3{
    private ATM atm;
    public task3(ATM atm){
        this.atm = atm;
        JFrame f = new JFrame("ATM INTERFACE");
        f.setVisible(true);
        f.setSize(500,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        f.add(p);
        p.setLayout(new GridLayout(5, 1));

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Balance Inquiry");
        /* depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this); */ 
        JLabel titlelbl = new JLabel("<html><u>ATM</u></html>");
        titlelbl.setHorizontalAlignment(JLabel.CENTER);
        // Create a Font object with bold style and a specific size
        Font boldFont = new Font(titlelbl.getFont().getName(), Font.BOLD, 24);
            
        // Set the font for the JLabel
        titlelbl.setFont(boldFont);
        JLabel statuslbl = new JLabel("");
        statuslbl.setHorizontalAlignment(JLabel.CENTER);
        p.add(titlelbl);
        p.add(depositBtn);
        p.add(withdrawBtn);
        p.add(balanceBtn);
        p.add(statuslbl);
        
    withdrawBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == withdrawBtn){
            String amount = JOptionPane.showInputDialog("Enter withdraw amount: ");
            try {
                double amountValue = Double.parseDouble(amount);
                boolean passStatus = atm.withdraw(amountValue);
                if (passStatus) {
                    statuslbl.setText("Withdrawal successful. New balance is : " + atm.checkBalance());
                } else {
                    statuslbl.setText("Insufficient amount to withdraw. Current balance is: " + atm.checkBalance());
                }
            } catch (NumberFormatException ex) {
                statuslbl.setText("Invalid input. Please enter a valid amount.");
            }
        }
    }
    });
    depositBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == depositBtn){
            String amount = JOptionPane.showInputDialog("Enter amount to deposit:");
            try {
                double amountValue = Double.parseDouble(amount);
                atm.deposit(amountValue);
                statuslbl.setText("Deposited successfully. New balance is: " + atm.checkBalance());
            } catch (NumberFormatException ex) {
                statuslbl.setText("Invalid input. Please enter a valid amount.");
            }
        }
    }
    });
    balanceBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == balanceBtn){
            statuslbl.setText("Current balance is: " + atm.checkBalance());
        }
    }
    });
    }

    public static void main(String[] args) {
        savingsAccount account = new savingsAccount(1000);
        ATM atm = new ATM(account);
        new task3(atm);
    }
}
