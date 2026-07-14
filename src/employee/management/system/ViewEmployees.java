package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener
{
    JTable table;
    Choice cid;
    JButton search, print, update, back;
    
    ViewEmployees()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searche = new JLabel("Search by employee ID");
        searche.setBounds(20, 20, 150, 20);
        add(searche);
        
        cid = new Choice();
        cid.setBounds(180, 20, 150, 20);
        add(cid);

        // ✅ JTable initialize FIRST
        table = new JTable();
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next())
            {
                cid.add(rs.getString("employee_id"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // load table data
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        { 
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new ViewEmployees();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == search)
        {
            String query = "select * from employee where employee_id = '"+cid.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ea)
            {
                ea.printStackTrace();
            }
        }
        else if(e.getSource() == print)
        {
            try
            {
                table.print();
            }catch(Exception ea)
            {
                ea.printStackTrace();
            }
        }
        else if(e.getSource() == update)
        {
            setVisible(false);
            new UpdateEmployee(cid.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
}

