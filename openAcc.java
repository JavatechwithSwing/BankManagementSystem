import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class openAcc extends JFrame  {

    Container cp;
    JLabel l1,l2,l3,Mname,Sname,greet;
    JTextField t1,t2,t3,mName,sName;
    JButton b1,Cancel;

    public boolean isRight;
    private Myclass myclass;

    public openAcc(Myclass myclass)
    {
        this.myclass=myclass;

        JFrame frame = new JFrame("Open Account");
        frame.setBounds(100,100,700,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.BLACK);
        cp.setLayout(null);

        greet = new JLabel("Creating 0 balance Account....");
        greet.setBounds(50,10,300,50);
        greet.setForeground(Color.white);
        greet.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(greet);

        l1 = new JLabel("Enter First Name: ");
        l1.setBounds(50,50,200,50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(l1);

        t1 = new JTextField();
        t1.setBounds(300,70,200,30);
        cp.add(t1);

        Mname = new JLabel("Enter Middle Name: ");
        Mname.setBounds(50,100,200,50);
        Mname.setForeground(Color.white);
        Mname.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(Mname);

        mName=new JTextField();
        mName.setBounds(300,120,200,30);
        cp.add(mName);

        Sname =new JLabel("Enter Last Name: ");
        Sname.setBounds(50,160,200,30);
        Sname.setForeground(Color.white);
        Sname.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(Sname);

        sName = new JTextField();
        sName.setBounds(300,170,200,30);
        cp.add(sName);

        l2 = new JLabel("Enter 4-digit pin: ");
        l2.setBounds(50,200,200,50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(l2);

        t2 = new JTextField();
        t2.setBounds(300,220,200,30);
        cp.add(t2);

        l3 = new JLabel("Confirm pin: ");
        l3.setBounds(50,250,200,50);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(l3);

        t3 = new JTextField();
        t3.setBounds(300,270,200,30);
        cp.add(t3);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(200, 350, 100, 30);
        Cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        Cancel.setOpaque(false);  // Transparent background
        Cancel.setContentAreaFilled(false); // Remove default fill
        Cancel.setBorderPainted(false); //Removing Button Border
        Cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        Cancel.setForeground(Color.WHITE); // Change text color
        Cancel.setFocusPainted(false);
        cp.add(Cancel);
        Cancel.addActionListener(e -> {frame.dispose(); });

        b1 = new JButton("Submit");
      //  b1.addActionListener(this);
        b1.setBounds(300,350,100,30);
        cp.add(b1);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        b1.setOpaque(false);  // Transparent background
        b1.setContentAreaFilled(false); // Remove default fill
        b1.setBorderPainted(false); //Removing Button Border
        b1.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        b1.setForeground(Color.white); // Change text color
        b1.setFocusPainted(false);
        b1.addActionListener(e -> openAcc());

    }
public openAcc() {
}


    public boolean isRight() {
        return isRight = true;
    }

    public void openAcc() {
        boolean confirmpin = myclass.openAcc(t2.getText());


            if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()||mName.getText().isEmpty()||sName.getText().isEmpty()) {

                System.out.println("Enter the details properly");
                JOptionPane.showMessageDialog(null, "Enter the details properly");


            }

   else {

        String n = t1.getText();
        System.out.println(n);

        String mname = mName.getText();
        String sname = sName.getText();

        String p1 = t2.getText();
        System.out.println(p1);
        if (p1.length() == 4) {

            String p2 = t3.getText();
            if (p1.equals(p2)) {



                int accNo = myclass.getInfos().size() + 5001;


                Info NewInfo = new Info(n,mname,sname, p2, accNo, 0);
                isRight = false;
                myclass.addInfo(NewInfo);

                isRight();

                t1.setText(" ");
                t2.setText(" ");
                t3.setText(" ");
                // openAcc(NewInfo);
            }
            else {
                System.out.println("Both password is different!");
                JOptionPane.showMessageDialog(null,"Both password is different!");
            }
        }
        else {
            System.out.println("Either your pin is less than 4-digit or greater than 4-digit!" +
                    "\ncheck your pin again!");
            JOptionPane.showMessageDialog(null,"check your pin again!");
        }

        if (isRight == true)
        {
            System.out.println("Congrats Your Account is Successfully Opened.");
            JDialog dialog = new JDialog();
            dialog.setUndecorated(true); // Removes the window border

            // Create a panel with green success message
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setLayout(new BorderLayout());

            // Green message label with a checkmark
            JLabel messageLabel = new JLabel("<html><font color='green' size='5'>✔  Successfully Opened!</font></html>", SwingConstants.CENTER);

            panel.add(messageLabel, BorderLayout.CENTER);

            dialog.add(panel);
            dialog.setSize(250, 100);
            dialog.setLocationRelativeTo(null); // Center the dialog
            dialog.setAlwaysOnTop(true);

            // Show the dialog for 2 seconds and then close it
            new Timer(2000, e -> dialog.dispose()).start();

            dialog.setVisible(true);

             // JOptionPane.showMessageDialog(null,"Successfully opened");
              SwingUtilities.invokeLater(() -> new Main(myclass));
        }



        }

       }

    }



