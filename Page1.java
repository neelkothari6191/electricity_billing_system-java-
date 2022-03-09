import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
  
public class Page1 {
  
    
    public static void CustomerInfo()
    {
  
        JFrame f
            = new JFrame(
                "Customer Details Form");
  
        
        JLabel l1, l2, l3, l4, l5;
  
       
        JTextField t1, t2, t3,t4;
  

        JComboBox j1;
  
        
        JButton b1, b2,b3;
  
        l1 = new JLabel("Customer Name:");
        l1.setBounds(50, 50, 100, 30);
        l2 = new JLabel("Customer ID:");
        l2.setBounds(50, 120, 120, 30);
        l3 = new JLabel("Consumer type:");
        l3.setBounds(10, 190, 100, 30);
        l4 = new JLabel("Units Consumed:");
        l4.setBounds(420, 50, 70, 30);
        l5 = new JLabel("Mobile No:");
        l5.setBounds(420, 120, 70, 30);
       
        t1 = new JTextField();
        t1.setBounds(150, 50, 130, 30);
        t2 = new JTextField();
        t2.setBounds(160, 120, 130, 30);
        t3 = new JTextField();
        t3.setBounds(490, 120, 130, 30);
        t4 = new JTextField();
        t4.setBounds(470, 50, 140, 30);
  
    
        String s1[]
            = { "  ", "Industrial", "Residential", "Commercial","Others" };
            
        
        
  
        
        j1 = new JComboBox(s1);
        j1.setBounds(120, 190, 100, 30);
        
        
  
    
        b1 = new JButton("Save");
        b1.setBounds(150, 300, 70, 30);
        b2 = new JButton("close");
        b2.setBounds(420, 300, 70, 30);
        b3 = new JButton("calculate");
        b3.setBounds(300, 300, 100, 30);
  
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
  
                
  
                String s1 = t1.getText();
                String s2 = t2.getText();
                String s3 = j1.getSelectedItem() + "";
                String s4 = t4.getText() + "";
                String s5 = t3.getText();
                if (e.getSource() == b1) {
                    try {
  
                        // Creating a file and
                        // writing the data
                        // into a Textfile.
                        FileWriter w
                            = new FileWriter(
                                "customer data.txt", true);
  
                        w.write(s1 + "\n");
                        w.write(s2 + "\n");
                        w.write(s3 + "\n");
                        w.write(s4 + "\n");
                        w.write(s5 + "\n");
                        w.close();
                    }
                    catch (Exception ae) {
                        System.out.println(ae);
                    }
                }
  
                JOptionPane
                    .showMessageDialog(
                        f,
                        "Successfully Saved"
                            + " The Details");
            }
        });
  
        // Action listener to close the form
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });

        //b3 calculate
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            
                new Page2();
            }
                });
  
        // Default method for closing the frame
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
  
        // Adding the created objects
        // to the frame
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(j1);
        f.add(l4);
        f.add(t4);
        f.add(l5);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setLayout(null);
        f.setSize(700, 600);
        f.setVisible(true);
    }
   
    public static void main(String args[])
    {
        CustomerInfo();
    }
}