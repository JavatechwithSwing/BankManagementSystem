import javax.swing.*;
import java.awt.*;

public class Deposite extends JFrame {

    private Myclass myclass;
    Container cp;
    JLabel Acc, amount, pin;
    JTextField AccNo, amountText, PinId;
    JButton Cancel, deposite;


    public Deposite(Myclass myclass) {
        this.myclass = myclass;
        JFrame frame = new JFrame("Deposit Money");
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
        AccNo.setBounds(230, 70, 150, 20);
        cp.add(AccNo);

        amount = new JLabel("Enter Amount: ");
        amount.setBounds(50, 100, 150, 50);
        amount.setForeground(Color.white);
        amount.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(amount);

        amountText = new JTextField();
        amountText.setBounds(230, 120, 150, 20);
        cp.add(amountText);

        pin = new JLabel("Enter Pin: ");
        pin.setBounds(50, 150, 150, 50);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(pin);

        PinId = new JTextField();
        PinId.setBounds(230, 170, 150, 20);
        cp.add(PinId);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(50, 250, 100, 30);
        cp.add(Cancel);
        Cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        Cancel.setOpaque(false);  // Transparent background
        Cancel.setContentAreaFilled(false); // Remove default fill
        Cancel.setBorderPainted(false); //Removing Button Border
        Cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        Cancel.setForeground(Color.WHITE); // Change text color
        Cancel.setFocusPainted(false);

        deposite = new JButton("Deposit");
        deposite.setBounds(190, 250, 100, 30);
        cp.add(deposite);
        deposite.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        deposite.setOpaque(false);  // Transparent background
        deposite.setContentAreaFilled(false); // Remove default fill
        deposite.setBorderPainted(false); //Removing Button Border
        deposite.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        deposite.setForeground(Color.WHITE); // Change text color
        deposite.setFocusPainted(false);

        Cancel.addActionListener(e ->{frame.dispose(); });
        //SwingUtilities.invokeLater(() -> new Main(myclass))
        deposite.addActionListener(e -> addDeposit());

    }

    private void addDeposit() {
        try {

            String text = AccNo.getText();
            int acc = Integer.parseInt(text);

            String amount = amountText.getText();
            double bal = Double.parseDouble(amount);

            String pin = PinId.getText();
            Info user = myclass.getInfobyDeposit(acc, bal, pin);

            if (user != null) {
                AccNo.setText(" ");
                amountText.setText(" ");
                PinId.setText(" ");
                JOptionPane.showMessageDialog(null, bal + " creadited on Acc no: " + user.getAccNo());
            } else {
                JOptionPane.showMessageDialog(null, "Check your Details again");
            }

        } catch (Exception e) {
            System.out.println("Exception Found!");
            throw new RuntimeException(e);
        }
    }

    public void closeWindow()
    {

    }
}
