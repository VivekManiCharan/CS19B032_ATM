package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements  ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField UserId = new JTextField();
    // JPasswordField Password = new JPasswordField();

    JLabel UserIdLabel = new JLabel("Account Number");
    //JLabel UserPasswordLabel = new JLabel("password");

    JLabel MessageLabel = new JLabel();

    public Login() {


        UserIdLabel.setBounds(20,50,350,50);
        UserIdLabel.setFont(new Font(null,Font.ITALIC,25));


        MessageLabel.setBounds(125,250,250,35);
        MessageLabel.setFont(new Font(null,Font.ITALIC,25));
        //MessageLabel.setVisible(true);

        UserId.setBounds(20,100,210,25);
        //Password.setBounds(20,100,210,25);

        loginButton.setBounds(20,150,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(140,150,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);




        panel.setSize(400,400);
        panel.setLayout(null);
        panel.setBackground(Color.cyan);
        panel.setVisible(true);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);


        frame.add(panel);

        panel.add(UserIdLabel);
        panel.add(MessageLabel);
        panel.add(UserId);
        panel.add(loginButton);
        panel.add(resetButton);

    }
    @Override
    public void actionPerformed(ActionEvent e){


        if(e.getSource() == resetButton){
            UserId.setText("");
            // Password.setText("");

        }
        if(e.getSource()== loginButton){

            Get obj = new Get();
            String userID = UserId.getText();
            // String password = String.valueOf(Password.getPassword());

            if(obj.GetName(userID) != null){

                MessageLabel.setForeground(Color.GREEN);
                MessageLabel.setText("Login successful");
                panel.add(MessageLabel);
                panel.setVisible(false);
                Validation welcomePage = new Validation(frame,userID);


            }
            else {
                UserId.setText("");
                MessageLabel.setForeground(Color.RED);
                MessageLabel.setText("Invalid Number");
                panel.add(MessageLabel);

            }



        }
    }

}