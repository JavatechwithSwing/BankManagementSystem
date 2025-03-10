import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    private Myclass myclass;
    Container cp;
    JLabel detail,countl;
    JButton details,count,back;
    public Admin(Myclass myclass)
    {
        this.myclass = myclass;
        JFrame frame = new JFrame("Only For Admin Use");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 500);
        frame.setVisible(true);
        cp = frame.getContentPane();
        frame.getContentPane().setBackground(Color.BLACK);
        cp.setLayout(null);

        detail = new JLabel("Check All Account Details: ");
        detail.setForeground(Color.white);
        detail.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        detail.setBounds(50,50,250,30);
        cp.add(detail);

        details = new JButton("Click Me");
        details.setBounds(300,50,100,30);
        cp.add(details);
        details.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        details.setOpaque(false);  // Transparent background
        details.setContentAreaFilled(false); // Remove default fill
        details.setBorderPainted(false); //Removing Button Border
        details.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        details.setForeground(Color.WHITE); // Change text color
        details.setFocusPainted(false);
        details.addActionListener(e -> SwingUtilities.invokeLater(() ->new AllDetails(myclass)));

        countl = new JLabel("Total Accounts");
        countl.setForeground(Color.white);
        countl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        countl.setBounds(50,100,150,30);
        cp.add(countl);

        count = new JButton("Count");
        count.setBounds(300,100,100,30);
        cp.add(count);
        count.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        count.setOpaque(false);  // Transparent background
        count.setContentAreaFilled(false); // Remove default fill
        count.setBorderPainted(false); //Removing Button Border
        count.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        count.setForeground(Color.WHITE); // Change text color
        count.setFocusPainted(false);
        count.addActionListener(e -> JOptionPane.showMessageDialog(null,"Total Accounts is "+myclass.Count()));

        back = new JButton("Back");
        back.setBounds(50,200,100,30);
        cp.add(back);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        back.setOpaque(false);  // Transparent background
        back.setContentAreaFilled(false); // Remove default fill
        back.setBorderPainted(false); //Removing Button Border
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Change font style & size
        back.setForeground(Color.WHITE); // Change text color
        back.setFocusPainted(false);
        back.addActionListener(e -> {frame.dispose(); });

    }


}
