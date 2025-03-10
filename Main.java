//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;


public class Main extends JFrame  {

    Container cp;
    JLabel label;
    JButton openacc,showDetails,deposit,withdraw,admin,Changepin,transfer;
    Myclass myclass;
    public Main(Myclass myclass)
    {

        this.myclass = myclass;
        JFrame frame = new JFrame("Bank Management System");
        frame.setBounds(100,100,700,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.black);

        cp.setLayout(null);

        label=new JLabel(" Welcome To The Bank Management System ...");
        label.setForeground(Color.white);
        label.setBounds(80,10,400,60);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(label);

        admin = new JButton("Admin Use");
        admin.setBounds(530,10,150,30);
        cp.add(admin);
        admin.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        admin.setOpaque(false);  // Transparent background
        admin.setContentAreaFilled(false); // Remove default fill
        admin.setBorderPainted(false); //Removing Button Border
        admin.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // Change font style & size
        admin.setForeground(Color.WHITE); // Change text color
        admin.setFocusPainted(false);

        admin.addActionListener(e -> SwingUtilities.invokeLater(()->checkDetails()));

        openacc = new JButton("Open Account");
       // b1.addActionListener(this);
        openacc.setBounds(80,100,150,30);
        cp.add(openacc);
        openacc.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        openacc.setOpaque(false);  // Transparent background
        openacc.setContentAreaFilled(false); // Remove default fill
        openacc.setBorderPainted(false); //Removing Button Border
        openacc.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        openacc.setForeground(Color.WHITE); // Change text color
        openacc.setFocusPainted(false);
        openacc.addActionListener(e -> SwingUtilities.invokeLater(() -> new openAcc(myclass)) );

        showDetails = new JButton("Check Details");
        showDetails.setBounds(350,100,150,30);
        cp.add(showDetails);
        showDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        showDetails.setOpaque(false);  // Transparent background
        showDetails.setContentAreaFilled(false); // Remove default fill
        showDetails.setBorderPainted(false); //Removing Button Border
        showDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        showDetails.setForeground(Color.WHITE); // Change text color
        showDetails.setFocusPainted(false);
        showDetails.addActionListener(e ->SwingUtilities.invokeLater(() -> new showDetails(myclass)) );

        deposit = new JButton("Deposit Money");
        deposit.setBounds(80,170,150,30);
        cp.add(deposit);
        deposit.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        deposit.setOpaque(false);  // Transparent background
        deposit.setContentAreaFilled(false); // Remove default fill
        deposit.setBorderPainted(false); //Removing Button Border
        deposit.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        deposit.setForeground(Color.WHITE); // Change text color
        deposit.setFocusPainted(false);
        deposit.addActionListener(e ->SwingUtilities.invokeLater(() -> new Deposite(myclass)) );

        withdraw = new JButton("Withdraw Cash");
        withdraw.setBounds(350,170,170,30);
        cp.add(withdraw);
        withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        withdraw.setOpaque(false);  // Transparent background
        withdraw.setContentAreaFilled(false); // Remove default fill
        withdraw.setBorderPainted(false); //Removing Button Border
        withdraw.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        withdraw.setForeground(Color.WHITE); // Change text color
        withdraw.setFocusPainted(false);
        withdraw.addActionListener(e -> SwingUtilities.invokeLater(()->new Withdraw(myclass)));

        Changepin = new JButton("Change Pin");
        Changepin.setBounds(80,250,150,30);
        cp.add(Changepin);
        Changepin.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        Changepin.setOpaque(false);  // Transparent background
        Changepin.setContentAreaFilled(false); // Remove default fill
        Changepin.setBorderPainted(false); //Removing Button Border
        Changepin.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        Changepin.setForeground(Color.WHITE); // Change text color
        Changepin.setFocusPainted(false);
        Changepin.addActionListener(e -> SwingUtilities.invokeLater(()->new ChangePin(myclass)));

        transfer = new JButton("Transfer Money");
        transfer.setBounds(350,250,170,30);
        cp.add(transfer);
        transfer.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        transfer.setOpaque(false);  // Transparent background
        transfer.setContentAreaFilled(false); // Remove default fill
        transfer.setBorderPainted(false); //Removing Button Border
        transfer.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        transfer.setForeground(Color.WHITE); // Change text color
        transfer.setFocusPainted(false);
        transfer.addActionListener(e -> SwingUtilities.invokeLater(()->new TransferMoney(myclass)));
    }
    private void checkDetails()
    {
        String pin = JOptionPane.showInputDialog("Enter Your PIN:");
        if (pin.equals("1212"))
        {
            String pass = JOptionPane.showInputDialog("Enter Your Password:");
            if (pass.equals("ass"))
            {
                SwingUtilities.invokeLater(()->new Admin(myclass));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect password!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Incorrect PIN!");
        }
    }



    public static void main(String[] args) {
    Myclass myclass = new Myclass();
    myclass.addInfo(new Info("Shiv","sadashiv","jadhav","1122",5001,8900));
    myclass.addInfo(new Info("Rohan","nayan","mane","1212",5002,4700));
    myclass.addInfo(new Info("Priyansh","arnav","patil","1221",5003,7500));
    new Main(myclass);
    }


}
