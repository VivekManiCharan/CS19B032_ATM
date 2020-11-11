package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Responses implements ActionListener {
    JPanel DepositPanel= new JPanel();
    JPanel WithdrawPanel= new JPanel();

    JPanel BalancePanel= new JPanel();
    JPanel MiniStatementPanel= new JPanel();
    JFrame ResponseFrame  = new JFrame();

    Get obj = new Get();


    JButton ChangeButton = new JButton("Enter");
    Responses(JFrame frame,int Response,String AccountNumber){
        ResponseFrame = frame;
        switch (Response){
            case 1:
                JLabel Deposit = new JLabel("Enter a Valid Amount");
                Deposit.setBounds(20,50,350,50);
                Deposit.setFont(new Font(null,Font.PLAIN,20));
                ResponseFrame.add(DepositPanel);
                DepositPanel.setSize(420,420);
                DepositPanel.setLayout(null);
                DepositPanel.setBackground(Color.cyan);
                DepositPanel.setVisible(true);

                DepositPanel.setSize(420,420);
                DepositPanel.setLayout(null);
                DepositPanel.setBackground(Color.cyan);
                DepositPanel.setVisible(true);


                break;
            case 2 :

                JLabel Withdraw = new JLabel("Enter a Valid Amount");
                Withdraw.setBounds(20,50,350,50);
                Withdraw.setFont(new Font(null,Font.PLAIN,20));

                ResponseFrame.add(WithdrawPanel);
                WithdrawPanel.setSize(420,420);
                WithdrawPanel.setLayout(null);
                WithdrawPanel.setBackground(Color.cyan);
                WithdrawPanel.setVisible(true);

                WithdrawPanel.setSize(420,420);
                WithdrawPanel.setLayout(null);
                WithdrawPanel.setBackground(Color.cyan);
                WithdrawPanel.setVisible(true);
                break;
            case 3:
                long balance = obj.GetBalance(AccountNumber);
                JLabel Balance = new JLabel(String.valueOf(balance));
                Balance.setBounds(20,50,350,50);
                Balance.setFont(new Font(null,Font.PLAIN,20));
                ResponseFrame.add(BalancePanel);
                BalancePanel.setSize(420,420);
                BalancePanel.setLayout(null);
                BalancePanel.setBackground(Color.cyan);
                BalancePanel.setVisible(true);

                BalancePanel.setSize(420,420);
                BalancePanel.setLayout(null);
                BalancePanel.setBackground(Color.cyan);
                BalancePanel.setVisible(true);
                break;
            case 4:

                break;
            case 5:
                ResponseFrame.add(MiniStatementPanel);
                MiniStatementPanel.setSize(420,420);
                MiniStatementPanel.setLayout(null);
                MiniStatementPanel.setBackground(Color.cyan);
                MiniStatementPanel.setVisible(true);

                MiniStatementPanel.setSize(420,420);
                MiniStatementPanel.setLayout(null);
                MiniStatementPanel.setBackground(Color.cyan);
                MiniStatementPanel.setVisible(true);
                break;

        }
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == ChangeButton){

        }
    }

}
