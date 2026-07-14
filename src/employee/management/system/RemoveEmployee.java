
package employee.management.system;

import java.awt.Choice;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener
{
    Choice ceid;
    JButton delete,back;
    
    RemoveEmployee()
    {
       getContentPane().setBackground(white);
       setLayout(null);
       
       JLabel jleid= new JLabel("Employee ID");
       jleid.setBounds(50, 50, 100, 30);
       add(jleid);
       
       ceid = new Choice();
       ceid.setBounds(200, 50, 150, 30);
       add(ceid);
       
       try {
          Conn c= new Conn();
          String query = "select * from employee";
          ResultSet rs =c.s.executeQuery(query);
          while(rs.next())
          {
              ceid.add(rs.getString("employee_id"));
          }
       }catch(Exception e)
       {
        e.printStackTrace();
       }
       
       JLabel jlname= new JLabel("Name");
       jlname.setBounds(50, 100, 100, 30);
       add(jlname);
       
       JLabel jname= new JLabel();
       jname.setBounds(200, 100, 100, 30);
       add(jname);
       
       JLabel jlphone= new JLabel("Phone");
       jlphone.setBounds(50, 150, 100, 30);
       add(jlphone);
       
       JLabel jphone= new JLabel();
       jphone.setBounds(200, 200, 100, 30);
       add(jphone);
       
       JLabel jlemail= new JLabel("Email");
       jlemail.setBounds(50, 200, 100, 30);
       add(jlemail);
       
       JLabel jemail= new JLabel();
       jemail.setBounds(200, 150, 100, 30);
       add(jemail);
       
       try {
          Conn c= new Conn();
          String query = "select * from employee where employee_id = '"+ceid.getSelectedItem()+"'";
          ResultSet rs =c.s.executeQuery(query);
          while(rs.next())
          {
             jname.setText(rs.getString("name"));
             jphone.setText(rs.getString("phone"));
             jemail.setText(rs.getString("email"));
          }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       ceid.addItemListener(new ItemListener(){ 
           public void itemStateChanged(ItemEvent ie){
               try {
                     Conn c= new Conn();
                     String query = "select * from employee where empl0yee_id = '"+ceid.getSelectedItem()+"'";
                     ResultSet rs =c.s.executeQuery(query);
                     while(rs.next())
                     {
                       jname.setText(rs.getString("name"));
                       jphone.setText(rs.getString("phone"));
                       jemail.setText(rs.getString("email"));
                       
                     }
                    }catch(Exception e)
                  {
                    e.printStackTrace();
                  }
           }
       });
       
       delete = new JButton("Delete");
       delete.setBounds(80, 300, 100, 30);
       delete.setBackground(black);
       delete.addActionListener(this);
       add(delete);
       
       back = new JButton("Back");
       back.setBounds(220, 300, 100, 30);
       back.setBackground(black);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 =i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
       
       setSize(1000,400);
       setLocation(300,150);
       setVisible(true);
    }
    public static void main(String args[])
    {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==delete)
        {
            try
            {
                Conn c= new Conn();
                String query = "delete from employee where employee_id = '"+ceid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Delete Sucessfully");
                setVisible(false);
                new Home();
            }catch(Exception ea)
            {
                ea.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Home();
        }
    
    }
    
}
