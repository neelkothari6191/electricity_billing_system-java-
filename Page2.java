import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Page2 extends JFrame implements ActionListener
{
    HashMap<String, String> consumer_and_price;
    
    DefaultListModel<String> product_name_bill, product_quantity_bill,product_price_bill,id_bill;
    
    JLabel consumer_type, price_per_unit, unitsconsumed_label, price_of_product,  price_per_unit_label, total, total_amount, bill_product, bill_quantity, bill_price,id_label,bill_id;
    JComboBox consumer_type_list, units_consumed_list,id_list;
    JList product_bill, product_quantity, product_price,id;
    JButton add_entry;

    
    
    public Page2()
    {
        consumer_and_price = new HashMap<String, String>();
        
        consumer_and_price.put("Industry", "8");
        consumer_and_price.put("Commercial", "10");
        consumer_and_price.put("Residential", "7");
                
        product_name_bill = new DefaultListModel<>();
        product_price_bill = new DefaultListModel<>();
        product_quantity_bill = new DefaultListModel<>();
        id_bill = new DefaultListModel<>();
        
        consumer_type = new JLabel("Consumer Type");
        unitsconsumed_label = new JLabel("Units Consumed");
        price_per_unit = new JLabel("Price Per Unit(₹)");
        id_label = new JLabel("Id");
        price_per_unit_label = new JLabel("8");

        
        
        consumer_type_list = new JComboBox();
        units_consumed_list = new JComboBox();
        id_list = new JComboBox();
                
        consumer_and_price.forEach((key,value)->
        {
            consumer_type_list.addItem(key);
        });
        
        for(int i=1; i<=500; i++)
        {
            units_consumed_list.addItem(Integer.toString(i));
        }

        for(int i=1; i<=500; i++)
        {
            id_list.addItem(Integer.toString(i));
        }
        
        bill_product = new JLabel("Consumer Type");
        bill_quantity = new JLabel("Units Consumed");
        bill_price = new JLabel("Cost");
        bill_id = new JLabel("Id");//
        
        product_bill = new JList(product_name_bill);
        product_price = new JList(product_price_bill);
        product_quantity = new JList(product_quantity_bill);
        id = new JList(id_bill);//
        
        add_entry = new JButton("Add Entry");
        
        total = new JLabel("Total Amount : ");
        total_amount = new JLabel();
        
        consumer_type.setBounds(10, 30, 100, 20);
        price_per_unit.setBounds(150, 30, 100, 20);
        unitsconsumed_label.setBounds(250, 30, 100, 20);
        price_per_unit_label.setBounds(150, 50, 100, 20);
        id_label.setBounds(400,30,100,20);//
        
        consumer_type_list.setBounds(10, 50, 100, 20);
        units_consumed_list.setBounds(250, 50, 100, 20);
        id_list.setBounds(400,50,100,20);//
      
        add_entry.setBounds(10, 80, 400, 50);
        
        bill_product.setBounds(10, 150, 150, 20);
        bill_quantity.setBounds(170, 150, 90, 20);
        bill_price.setBounds(270, 150, 140, 20);
        bill_id.setBounds(370,150,140,20);//
        
        product_bill.setBounds(10, 175, 150, 400);
        product_quantity.setBounds(170, 175, 90, 400);
        product_price.setBounds(270, 175, 140, 400);
        id.setBounds(370,175,150,400);
        
        total.setBounds(140, 575, 200, 20);
        total_amount.setBounds(400, 575, 90, 20);
                
        add(consumer_type);
        add(price_per_unit);
        add(unitsconsumed_label);
        add(id_label);
        
        add(price_per_unit_label);
        add(consumer_type_list);
        add(units_consumed_list);
        add(id_list);
        
        add(add_entry);
        
        add(bill_product);
        add(bill_quantity);
        add(bill_price);
        add(bill_id);
        
        add(product_bill);
        add(product_quantity);
        add(product_price);
        add(id);
        
        add(total);
        add(total_amount);
        
        consumer_type_list.addActionListener(this);
        add_entry.addActionListener(this);
        id_list.addActionListener(this);

        
        setSize(550,650);
        setLayout(null);
        setVisible(true);
        setTitle("My Billing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add_entry)
        {
            product_name_bill.addElement((String) consumer_type_list.getSelectedItem());
            product_quantity_bill.addElement((String) units_consumed_list.getSelectedItem());
            id_bill.addElement((String) id_list.getSelectedItem());
            int unit_price = Integer.parseInt(consumer_and_price.get(consumer_type_list.getSelectedItem()));
            int product_quantity = Integer.parseInt((String) units_consumed_list.getSelectedItem());
            int id = Integer.parseInt((String)id_list.getSelectedItem());
            int total_for_product = unit_price*product_quantity; 
            int total_cost = 0;
            product_price_bill.addElement(Integer.toString(total_for_product));
            
            for(int i=0;i<product_price_bill.getSize();i++)
            {
                total_cost += Integer.parseInt(product_price_bill.getElementAt(i));
            }
            
            total_amount.setText(Integer.toString(total_cost));
        }
        else if(e.getSource()==consumer_type_list)
        {
            price_per_unit_label.setText(consumer_and_price.get(consumer_type_list.getSelectedItem()));
        }
    }

    public static void main(String[] args)
    {
        Page2 ms = new Page2();
    }
}