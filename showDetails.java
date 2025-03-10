import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class showDetails extends openAcc {

  //  public List<Info> infos;
   // private List<Customer> customers;
    private JFrame frame;
    private JTextArea displayArea;
    private JButton checkd,back;
    private Myclass myclass;
    public showDetails(Myclass myclass)
    {

        this.myclass = myclass;
       // infos = new ArrayList<>();
       // customers = new ArrayList<>();
        frame = new JFrame("Check details");
        frame.setBounds(100,100,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.BOLD, 14));
        displayArea.setForeground(Color.white);
        displayArea.setBackground(Color.BLACK);

        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.black);

        checkd = new JButton("check Details");
        checkd.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        checkd.setOpaque(false);  // Transparent background
        checkd.setContentAreaFilled(false); // Remove default fill
        checkd.setBorderPainted(false); //Removing Button Border
        checkd.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // Change font style & size
        checkd.setForeground(Color.WHITE); // Change text color
        checkd.setFocusPainted(false);


        back = new JButton("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));  //Setting Button Cursor (Hand Cursor on Hover)
        back.setOpaque(false);  // Transparent background
        back.setContentAreaFilled(false); // Remove default fill
        back.setBorderPainted(false); //Removing Button Border
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // Change font style & size
        back.setForeground(Color.WHITE); // Change text color
        back.setFocusPainted(false);


        buttonPanel.add(back);
        buttonPanel.add(checkd);

        frame.add(buttonPanel, BorderLayout.NORTH);

        checkd.addActionListener(e -> checkDetails() );
        back.addActionListener(e -> {frame.dispose(); });

        frame.setVisible(true);

    }
    public void addCustomer(Customer customer)
    {
       // customers.add(customer);
    }

    private void checkDetails()
    {
        String pin = JOptionPane.showInputDialog("Enter Your PIN:");

        Info account = myclass.getInfoByPin(pin);
        if (account != null) {
            displayArea.setText("\n\tName: " + account.getName() +
                    " "+account.getMname()+" "+account.getSname()+
                    "\n\tAccount No: " + account.getAccNo() +
                    "\n\tBalance: $" + account.getBalance());
        } else {
            displayArea.setText("\n\tInvalid PIN! No details found.");
        }

    }


}
