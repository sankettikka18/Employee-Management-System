
package employee.management.system;

import java.awt.*;
import java.sql.*;
import static java.awt.Color.WHITE;
import static java.awt.Color.black;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame implements ActionListener
{   
    JTextField tfe,tf1,tf3,tf4,tf5,tf6,tf8,tf9;
    JLabel leid,lid;
    JButton add,back;
    String eid;
            
    UpdateEmployee(String eid)
    {
        this.eid = eid;
        getContentPane().setBackground(WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(50,150,150,30);
        l1.setFont(new Font("serif",Font.PLAIN,20));
        add(l1);
        
        JLabel tfname=new JLabel();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel l2=new JLabel("Father's Name");
        l2.setBounds(400,150,150,30);
        l2.setFont(new Font("serif",Font.PLAIN,20));
        add(l2);
        
        tf1=new JTextField();
        tf1.setBounds(600, 150, 150, 30);
        add(tf1);
        
        JLabel l3=new JLabel("Date Of Birth");
        l3.setBounds(50,200,150,30);
        l3.setFont(new Font("serif",Font.PLAIN,20));
        add(l3);
        
        JLabel ldob = new JLabel();
        ldob.setBounds(200, 200, 150, 30);
        add(ldob);
        
        JLabel l4=new JLabel("Salary");
        l4.setBounds(400,200,150,30);
        l4.setFont(new Font("serif",Font.PLAIN,20));
        add(l4);
        
        tf3=new JTextField();
        tf3.setBounds(600, 200, 150, 30);
        add(tf3);
        
        JLabel l5=new JLabel("Address");
        l5.setBounds(50,250,150,30);
        l5.setFont(new Font("serif",Font.PLAIN,20));
        add(l5);
        
        tf4=new JTextField();
        tf4.setBounds(200, 250, 150, 30);
        add(tf4);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(400,250,150,30);
        l6.setFont(new Font("serif",Font.PLAIN,20));
        add(l6);
        
        tf5=new JTextField();
        tf5.setBounds(600, 250, 150, 30);
        add(tf5);
        
        JLabel l7=new JLabel("Email");
        l7.setBounds(50,300,150,30);
        l7.setFont(new Font("serif",Font.PLAIN,20));
        add(l7);
        
        
        tf6=new JTextField();
        tf6.setBounds(200, 300, 150, 30);
        add(tf6);
        
        JLabel l8=new JLabel("Education");
        l8.setBounds(400,300,150,30);
        l8.setFont(new Font("serif",Font.PLAIN,20));
        add(l8);
        
        tfe=new JTextField();
        tfe.setBounds(600, 300, 150, 30);
        add(tfe);
        
         JLabel l9=new JLabel("Designation");
        l9.setBounds(50,350,150,30);
        l9.setFont(new Font("serif",Font.PLAIN,20));
        add(l9);
        
        tf8=new JTextField();
        tf8.setBounds(200, 350, 150, 30);
        add(tf8);
        
        JLabel l0=new JLabel("Aadhar Number");
        l0.setBounds(400,350,150,30);
        l0.setFont(new Font("serif",Font.PLAIN,20));
        add(l0);
        
       JLabel jla=new JLabel();
        jla.setBounds(600, 350, 150, 30);
        add(jla);
        
       JLabel leid=new JLabel("Employee ID");
        leid.setBounds(50,400,150,30);
        leid.setFont(new Font("serif",Font.PLAIN,20));
        add(leid);
        
        leid=new JLabel();
        leid.setBounds(200,400,150,30);
        leid.setFont(new Font("serif",Font.PLAIN,20));
        add(leid);
        
        try
        {
            Conn c =new Conn();
            String query = "select * from employee where id = '"+eid+"'";
            c.s.executeQuery(query);
            ResultSet rsa= c.s.executeQuery(query);
            while(rsa.next())
            {
                tfname.setText(rsa.getString("name"));
                tf1.setText(rsa.getString("fname"));
                ldob.setText(rsa.getString("db"));
                tf3.setText(rsa.getString("sl"));
                tf4.setText(rsa.getString("ad"));
                tf5.setText(rsa.getString("ph"));
                tf6.setText(rsa.getString("em"));
                tfe.setText(rsa.getString("ed"));
                tf8.setText(rsa.getString("de"));
                jla.setText(rsa.getString("aad"));
                leid.setText(rsa.getString("id"));
            }
        }catch(Exception e)
        {
            
        }
        
        add= new JButton("Update Datails");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(black);
        add.setForeground(WHITE);
        add(add);
        
        back= new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(black);
        back.setForeground(WHITE);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 650);
        add(image);
        
        setSize(900,650);
        setLocation(250,50);
        setVisible(true);
        

    }
    
    public static void main(String args[])
    {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == add)
        {
            String fname = tf1.getText();
            String sl = tf3.getText();
            String ad = tf4.getText();
            String ph = tf5.getText();
            String em = tf6.getText();
            String ed = tfe.getText();
            String de = tf8.getText();
            
            try
            {
                Conn con= new Conn();
                String query = "update employee set fname = '"+fname+"', sl= '"+sl+"', ad= '"+ad+"', ph= '"+ph+"', em= '"+em+"', ed= '"+ed+"', de= '"+de+"' where id= '"+eid+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Datails Updated successfully");
                setVisible(false);
                new Home();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
}

