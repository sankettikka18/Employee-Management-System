
package employee.management.system;

import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
    JTextField jtusername;
    JPasswordField jtpassword; 
    
    Login()
    {
        getContentPane().setBackground(white);
        setLayout(null);
        
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(40, 20, 100, 30);
        add(jlusername);
        
        jtusername = new JTextField();
        jtusername.setBounds(150, 20, 150,30 );
        add(jtusername);
        
        JLabel jlpassword = new JLabel("Password");
        jlpassword.setBounds(40, 70, 100, 30);
        add(jlpassword);
        
          jtpassword = new JPasswordField();
        jtpassword.setBounds(150, 70, 150,30 );
        add(jtpassword);
        
         JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 70);
        login.setBackground(black);
        login.setForeground(white);
        login.addActionListener(this);
       add(login);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600,300);
        setVisible(true);
        setLocation(400,200);
    }
    
  
    public static void main(String args[])
    {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            String username = jtusername.getText();
            String password = new String(jtpassword.getPassword());
            
            Conn c=new Conn();
            String query ="select * from login where username = '"+username+"' and password = '"+password+"'";
            
           ResultSet rs = c.s.executeQuery(query);
           if(rs.next()){
           setVisible(false);
           new Home();   // login successful → home open
    }
           else
    {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
   
    }
     
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
}
