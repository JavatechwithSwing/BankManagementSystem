import javax.swing.*;
import java.awt.*;

public class Withdraw extends JFrame {
    private Myclass myclass;
    Container cp;
    JLabel Acc, amount, pin;
    JTextField AccNo, amountText, PinId;
    JButton Cancel, withdraw;

    public Withdraw(Myclass myclass)
    {
        this.myclass = myclass;
        JFrame frame = new JFrame("Withdraw Cash");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 500);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.BLACK);
        cp.setLayout(null);

        Acc = new JLabel("Enter Account No: ");
        Acc.setBounds(50, 50, 170, 50);
        Acc.setForeground(Color.white);
        Acc.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(Acc);

        AccNo = new JTextField();
        AccNo.setBounds(200, 70, 150, 20);
        cp.add(AccNo);

        amount = new JLabel("Enter Amount: ");
        amount.setBounds(50, 100, 150, 50);
        amount.setForeground(Color.white);
        amount.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(amount);

        amountText = new JTextField();
        amountText.setBounds(200, 120, 150, 20);
        cp.add(amountText);

        pin = new JLabel("Enter Pin: ");
        pin.setBounds(50, 150, 150, 50);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(pin);

        PinId = new JTextField();
        PinId.setBounds(200, 170, 150, 20);
        cp.add(PinId);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(50, 250, 100, 30);
        Cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        Cancel.setOpaque(false);  // Transparent background
        Cancel.setContentAreaFilled(false); // Remove default fill
        Cancel.setBorderPainted(false); //Removing Button Border
        Cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        Cancel.setForeground(Color.WHITE); // Change text color
        Cancel.setFocusPainted(false);
        cp.add(Cancel);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(190, 250, 130, 30);
        withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        withdraw.setOpaque(false);  // Transparent background
        withdraw.setContentAreaFilled(false); // Remove default fill
        withdraw.setBorderPainted(false); //Removing Button Border
        withdraw.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        withdraw.setForeground(Color.WHITE); // Change text color
        withdraw.setFocusPainted(false);
        cp.add(withdraw);

        Cancel.addActionListener(e -> {frame.dispose(); });
        withdraw.addActionListener(e -> SwingUtilities.invokeLater(()->withdraw()));
    }
    private void withdraw()
    {
        try {

            String text = AccNo.getText();
            int acc = Integer.parseInt(text);

            String amount = amountText.getText();
            double bal = Double.parseDouble(amount);

            String pin = PinId.getText();
            Info user = myclass.getInfobyWithdraw(acc, bal, pin);

            if (user != null) {
                AccNo.setText(" ");
                amountText.setText(" ");
                PinId.setText(" ");
                JOptionPane.showMessageDialog(null, bal + " Debit on Acc no: " + user.getAccNo());
            } else {
                JOptionPane.showMessageDialog(null, "Check your Details again");
            }

        } catch (Exception e) {
            System.out.println("Exception Found!");
            throw new RuntimeException(e);
        }

    }
}
