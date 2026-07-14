package employee.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class AddEmployees extends JFrame implements ActionListener {

    Random rn = new Random();
    int number = rn.nextInt(999999);

    JTextField tf, tf1, tf3, tf4, tf5, tf6, tf8, tf9;
    JDateChooser dob;
    JComboBox<String> tf7;
    JLabel lid;
    JButton add, back;

    AddEmployees() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(250, 20, 400, 40);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 100, 150, 30);
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        add(l1);

        tf = new JTextField();
        tf.setBounds(200, 100, 150, 30);
        add(tf);

        // Father Name
        JLabel l2 = new JLabel("Father's Name");
        l2.setBounds(400, 100, 150, 30);
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        add(l2);

        tf1 = new JTextField();
        tf1.setBounds(600, 100, 150, 30);
        add(tf1);

        // DOB
        JLabel l3 = new JLabel("Date Of Birth");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("serif", Font.PLAIN, 20));
        add(l3);

        dob = new JDateChooser();
        dob.setBounds(200, 150, 150, 30);
        add(dob);

        // Salary
        JLabel l4 = new JLabel("Salary");
        l4.setBounds(400, 150, 150, 30);
        l4.setFont(new Font("serif", Font.PLAIN, 20));
        add(l4);

        tf3 = new JTextField();
        tf3.setBounds(600, 150, 150, 30);
        add(tf3);

        // Address
        JLabel l5 = new JLabel("Address");
        l5.setBounds(50, 200, 150, 30);
        l5.setFont(new Font("serif", Font.PLAIN, 20));
        add(l5);

        tf4 = new JTextField();
        tf4.setBounds(200, 200, 150, 30);
        add(tf4);

        // Phone
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(400, 200, 150, 30);
        l6.setFont(new Font("serif", Font.PLAIN, 20));
        add(l6);

        tf5 = new JTextField();
        tf5.setBounds(600, 200, 150, 30);
        add(tf5);

        // Email
        JLabel l7 = new JLabel("Email");
        l7.setBounds(50, 250, 150, 30);
        l7.setFont(new Font("serif", Font.PLAIN, 20));
        add(l7);

        tf6 = new JTextField();
        tf6.setBounds(200, 250, 150, 30);
        add(tf6);

        // Education
        JLabel l8 = new JLabel("Education");
        l8.setBounds(400, 250, 150, 30);
        l8.setFont(new Font("serif", Font.PLAIN, 20));
        add(l8);

        String courses[] = {"BBA", "BA", "BCA", "B.COM", "BSc", "MBA", "MCA", "MA", "MSc", "PHD"};
        tf7 = new JComboBox<>(courses);
        tf7.setBackground(Color.WHITE);
        tf7.setBounds(600, 250, 150, 30);
        add(tf7);

        // Designation
        JLabel l9 = new JLabel("Designation");
        l9.setBounds(50, 300, 150, 30);
        l9.setFont(new Font("serif", Font.PLAIN, 20));
        add(l9);

        tf8 = new JTextField();
        tf8.setBounds(200, 300, 150, 30);
        add(tf8);

        // Aadhar
        JLabel l10 = new JLabel("Aadhar Number");
        l10.setBounds(400, 300, 150, 30);
        l10.setFont(new Font("serif", Font.PLAIN, 20));
        add(l10);

        tf9 = new JTextField();
        tf9.setBounds(600, 300, 150, 30);
        add(tf9);

        // Employee ID
        JLabel leid = new JLabel("Employee ID");
        leid.setBounds(50, 350, 150, 30);
        leid.setFont(new Font("serif", Font.PLAIN, 20));
        add(leid);

        lid = new JLabel("" + number);
        lid.setBounds(200, 350, 150, 30);
        lid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lid);

        // Buttons
        add = new JButton("Add Details");
        add.setBounds(250, 450, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame settings
        setSize(900, 600);
        setLocation(250, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String name = tf.getText();
            String fname = tf1.getText();
            if (dob.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please Select Date of Birth");
            return;
             }

           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dobText = sdf.format(dob.getDate());
            String salary = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String education = (String) tf7.getSelectedItem();
            String designation = tf8.getText();
            String aadhar = tf9.getText();
            String empId = lid.getText();

            try {
                Conn con = new Conn();

                
                String query = "INSERT INTO employee "
        + "(employee_id, name, date_of_birth, address, email, designation, father_name, salary, phone, education, aadhar_number) "
        + "VALUES ('" + empId + "', '" + name + "', '" + dobText + "', '" + address + "', '" + email + "', '" + designation + "', '" + fname + "', '" + salary + "', '" + phone + "', '" + education + "', '" + aadhar + "')";con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee Added Successfully");

                setVisible(false);
                new Home();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployees();
    }
}