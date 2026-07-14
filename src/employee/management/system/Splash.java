
package employee.management.system;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener
{
    Splash()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading= new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(60,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(black);
        clickhere.setForeground(white);
        clickhere.addActionListener(this);
        image.add(clickhere);
                
        setSize(1170,650);
        setLocation(100,30);
        setVisible(true);
        
        
//        while(true) {
//            heading.setVisible(false);
//            try{
//                Thread.sleep(20);
//            } catch (Exception e){
//                
//            }
//            heading.setVisible(true);
//        }
    }
    
    public void actionPerformed(ActionEvent ae) {
       setVisible(false);
       new Login();
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
