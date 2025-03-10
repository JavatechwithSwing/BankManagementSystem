import javax.swing.*;
import java.awt.*;

public class ChangePin extends JFrame {

    private Myclass myclass;
    Container cp;
    JLabel oldl,newl,confirml;
    JTextField oldt,newt,confirmt;
    JButton cancel,change;

    public ChangePin(Myclass myclass)
    {
        this.myclass = myclass;
        JFrame frame = new JFrame("Change PIN");
        frame.setBounds(100,100,700,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.BLACK);
        cp.setLayout(null);


        oldl = new JLabel("Enter Old Pin : ");
        oldl.setBounds(50, 50, 150, 50);
        oldl.setForeground(Color.white);
        oldl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(oldl);

        oldt = new JTextField();
        oldt.setBounds(200, 70, 150, 20);
        cp.add(oldt);

        newl = new JLabel("Enter New Pin : ");
        newl.setBounds(50, 100, 150, 50);
        newl.setForeground(Color.white);
        newl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(newl);

        newt = new JTextField();
        newt.setBounds(200, 120, 150, 20);
        cp.add(newt);

        confirml = new JLabel("Confirm Pin: ");
        confirml.setBounds(50, 150, 150, 50);
        confirml.setForeground(Color.white);
        confirml.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        cp.add(confirml);

        confirmt = new JTextField();
        confirmt.setBounds(200, 170, 150, 20);
        cp.add(confirmt);


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
        cancel.addActionListener(e -> {frame.dispose(); });

        change = new JButton("Change Pin");
        change.setBounds(190, 250, 150, 30);
        cp.add(change);
        change.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        change.setOpaque(false);  // Transparent background
        change.setContentAreaFilled(false); // Remove default fill
        change.setBorderPainted(false); //Removing Button Border
        change.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        change.setForeground(Color.WHITE); // Change text color
        change.setFocusPainted(false);
        change.addActionListener(e -> changePin());

    }
    public void changePin()
    {
        String old = oldt.getText();
        String newpin = newt.getText();
        String confirmpin = confirmt.getText();
      Info user = myclass.changePin(old,newpin,confirmpin);

      if (user != null) {
          if (newpin.equals(confirmpin))
          {
              JOptionPane.showMessageDialog(null,user.getAccNo()+" Successfully Update PIN,\n new PIN: "+user.getPin());
              oldt.setText(" ");
              newt.setText(" ");
              confirmt.setText(" ");
          }
      } else
      {
          JOptionPane.showMessageDialog(null,"Check Your PIN! Either try another PIN!");
      }

    }
}
