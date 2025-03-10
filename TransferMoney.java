import javax.swing.*;
import java.awt.*;

public class TransferMoney extends JFrame {
    private Myclass myclass;
    Container cp;
    JLabel accnol,amountl,pinl;
    JTextField accnot,amountt,pint;
    JButton cancel,transfer;

    public TransferMoney(Myclass myclass)
    {
        this.myclass = myclass;
        JFrame frame = new JFrame("Transfer Money");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(100,100,700,500);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.BLACK);
        cp.setLayout(null);

        accnol = new JLabel("Enter Transferee Account No: ");
        accnol.setBounds(50, 50, 250, 50);
        accnol.setForeground(Color.white);
        accnol.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(accnol);

        accnot = new JTextField();
        accnot.setBounds(300, 70, 150, 20);
        cp.add(accnot);

        amountl = new JLabel("Enter Amount : ");
        amountl.setBounds(50, 100, 150, 50);
        amountl.setForeground(Color.white);
        amountl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(amountl);

        amountt = new JTextField();
        amountt.setBounds(200, 120, 150, 20);
        cp.add(amountt);

        pinl = new JLabel("Enter Your Pin: ");
        pinl.setBounds(50, 150, 150, 50);
        pinl.setForeground(Color.white);
        pinl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(pinl);

        pint = new JTextField();
        pint.setBounds(200, 170, 150, 20);
        cp.add(pint);

        cancel = new JButton("Cancel");
        cancel.setBounds(50, 250, 100, 30);
        cp.add(cancel);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        cancel.setOpaque(false);  // Transparent background
        cancel.setContentAreaFilled(false); // Remove default fill
        cancel.setBorderPainted(false); //Removing Button Border
        cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        cancel.setForeground(Color.WHITE); // Change text color
        cancel.setFocusPainted(false);
        cancel.addActionListener(e ->{frame.dispose(); });

        transfer = new JButton("Transfer");
        transfer.setBounds(190, 250, 130, 30);
        cp.add(transfer);
        transfer.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        transfer.setOpaque(false);  // Transparent background
        transfer.setContentAreaFilled(false); // Remove default fill
        transfer.setBorderPainted(false); //Removing Button Border
        transfer.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        transfer.setForeground(Color.WHITE); // Change text color
        transfer.setFocusPainted(false);
        transfer.addActionListener(e -> tansferMoney());

    }
    private void tansferMoney()
    {
        String accno = accnot.getText();
       int acc = Integer.parseInt(accno);

       String balance = amountt.getText();
       double bal = Double.parseDouble(balance);

       String pin = pint.getText();

       Info User = myclass.transferMoney(acc,bal,pin);
       if (User != null)
       {
           JOptionPane.showMessageDialog(null,User.getAccNo()+" Debit RS."+bal+" Clear balance is: "+User.getBalance());
       }
       else
       {
           JOptionPane.showMessageDialog(null,"Check Your Information!");
       }



    }

}
