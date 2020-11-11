package com.company;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws SQLException {


        Scanner sc = new Scanner(System.in);
        Get obj = new Get();

        while(true){

            new Login();
            System.out.println("Enter Your Account Number");
            String AccountNumber = sc.next();


            obj.GetName(AccountNumber);

            if(obj.GetName(AccountNumber) != null){

                System.out.println("Hello "+obj.GetName(AccountNumber));
                System.out.println("Please Enter Your Pin");

                String Pin = sc.next();
                String encrypted = Base64.getEncoder().encodeToString(Pin.getBytes());
                if(encrypted.equals(obj.GetPin(AccountNumber))){

                    int OTP = OTPGenerator();
                    System.out.println("ENTER OTP :"+OTP);
                    int otp = sc.nextInt();
                    if(OTP == otp){
                        int response = 0;
                        System.out.println("\nSelect  any response " +obj.GetName(AccountNumber));
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Balance");
                        System.out.println("4. MiniStatement");
                        System.out.println("5.PinChange");

                        response = sc.nextInt();
                        execution(response,AccountNumber);
                    }
                    else{
                        System.out.println("2 Step Verification Failed");
                    }


                }
                else{
                    System.out.println("Invalid Pin Entered");
                }
            }
            else{
                System.out.println("Invalid Account Number Entered");
            }

        }
    }

    public static  int OTPGenerator(){
        Random OTPGenerator = new Random();
        OTPGenerator.setSeed(System.currentTimeMillis());
        int  OTP = OTPGenerator.nextInt(99999)+ 99999;
        while(OTP < 100000 || OTP > 999999){
            OTP = OTPGenerator.nextInt(99999)+ 99999;
        }
        return  OTP;
    }
    private static void execution(int response, String accountNumber) throws SQLException {

        Get obj = new Get();
        Scanner sc = new Scanner(System.in);
        long Amount =0;
        long Balance = obj.GetBalance(accountNumber);
        switch (response){
            case 1:
                System.out.println("Enter Amount");
                Amount = sc.nextLong();
                while(Amount == 0 || Amount%500 != 0){
                    System.out.println("Enter Valid Amount");
                    Amount = sc.nextLong();
                }

                    obj.Update(accountNumber,Balance + Amount);
                    obj.insert(obj.GetName(accountNumber), Amount,"Deposit     ");
                    System.out.println("\n\nTransaction Successful\n\n");


                break;
            case 2:
                System.out.println("Enter Amount");
                Amount = sc.nextLong();
                while(Amount == 0 || Amount%500 != 0){
                    System.out.println("Enter Valid Amount");
                    Amount = sc.nextLong();
                }
                if(Amount > 40000){
                    System.out.println("Transaction limit Exceeded");
                    System.out.println("\n\nTransaction UnSuccessful\n\n");

                }
                else if(Balance >= Amount){

                    obj.Update(accountNumber,Balance - Amount);
                    obj.insert(obj.GetName(accountNumber), Amount,"withdraw    ");
                    System.out.println("\n\nTransaction Successful\n\n");
                }
                else{
                    System.out.println("Insufficient Funds in your Account ");
                }
                System.out.println("Balance : "+(Balance - Amount));
                break;
            case 3:
                System.out.println("Balance : "+Balance);
                break;
            case 4:
                obj.Transactions(obj.GetName(accountNumber));
                break;
            case 5:
                System.out.println("Enter New Pin");
                String Pin = sc.next();
                System.out.println("Confirm New Pin");
                String ConfirmPin = sc.next();
                if(Pin.equals(ConfirmPin)){

                    obj.ChangePin(accountNumber,Base64.getEncoder().encodeToString(Pin.getBytes()));
                    System.out.println("Pin Changed Successfully");
                }
                else{
                    System.out.println("Both Pins are Not Matching \nPin Change UnSuccessful");
                }
                break;
            default:
                System.out.println("Invalid Entry");
        }
    }
}
