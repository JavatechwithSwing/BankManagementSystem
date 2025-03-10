import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class AllDetails extends JFrame {
    private Myclass myclass;
    JButton back;
    JTextArea displayArea ;
    Container cp;
    public AllDetails(Myclass myclass)
    {
        this.myclass = myclass;
        JFrame frame = new JFrame("All Details");
        frame.setBounds(100,100,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.black);

        back = new JButton("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        back.setOpaque(false);  // Transparent background
        back.setContentAreaFilled(false); // Remove default fill
        back.setBorderPainted(false); //Removing Button Border
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // Change font style & size
        back.setForeground(Color.WHITE); // Change text color
        back.setFocusPainted(false);

        buttonPanel.add(back);
        frame.add(buttonPanel, BorderLayout.NORTH);
        back.addActionListener(e -> {frame.dispose(); });


        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(Color.black);
        displayArea.setForeground(Color.white); // Set text color to green
        displayArea.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);


        List<Info> infoList = myclass.AllDetails();
        displayArea.setText(""); // Clear existing text
        int c = 1;
        for (Info info : infoList) {
            displayArea.append("  [ "+c+" ] "+info.toString() + "\n----------------------------" +
                    "------------------------------------------------------------\n");
            c++;
        }





    }

}
