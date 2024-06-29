package Banke;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Atm{
    private static Bank kuda = new Bank();
    public static void main(String[] args){
//JOptionPane.showMessageDialog(null, "Welcome to Banke");
      goToMainMenu();

    }

    public static String input(String prompt){
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(prompt);
//        return scanner.nextLine();
        return JOptionPane.showInputDialog(prompt);
    }

    public static void print(String prompt){
        JOptionPane.showMessageDialog(null, prompt);
    }

    public static void exitApplication(){
        print("Exiting application");
    }

    public static void createAccount(){
        String name = input("What is your name? ");
        String pin = input("What is your pin? ");
        kuda.addCustomer(pin,name);
        JOptionPane.showMessageDialog(null, "Account succesfully created\n Thank you "+ name +", for banking with us\n" + name);
        goToMainMenu();
    }

    public static void deposit(){
        try {
            int accountNumber = Integer.parseInt(input("what is your account number? "));
            int amount = Integer.parseInt(input("How much do you want to deposit? "));
            kuda.depositTo(accountNumber, amount);
            print("#"+amount + " Succesfully deposited");
        }catch(NumberFormatException e){
            print("enter a valid number");
        }
        catch(IllegalArgumentException e){
            print(e.getMessage());
        }
        goToMainMenu();
    }

    public static void withdraw(){
        try {
            int accountNumber = Integer.parseInt(input("what is your account number? "));
            int amount = Integer.parseInt(input("How much do you wannt to withdra? "));
            String pin = input("enter your pin");
            kuda.withdrawal(amount, pin, accountNumber);
            print("#" + amount + " Was succesfully withdrawn");
        } catch (NumberFormatException e){
            print("Enter a valid number");
        } catch (IllegalArgumentException e) {
            print( e.getMessage());
        }
        goToMainMenu();
    }

    public static void checkBalance(){
        int accountNumber = Integer.parseInt(input("What is your account number? "));
        String pin = input("What is your pin? ");
        kuda.checkBalanceFor(accountNumber, pin);
        goToMainMenu();
    }

    public static void transfer(){
        try {
            int destinationAccount = Integer.parseInt(input("Enter the account number you want to send to: "));
            int ownerAccountNumber = Integer.parseInt(input("Enter your account number: "));
            int amount = Integer.parseInt(input("How much are you sending? "));
            String pin = input("Enter your pin: ");
            kuda.transfer(destinationAccount, ownerAccountNumber, amount, pin);
            print("#" + amount + "has been transferred");
        } catch (NumberFormatException e){
            print("Enter a valid number");
        }
        catch(IllegalArgumentException e){
            print(e.getMessage());
        }
        goToMainMenu();
    }

    public static void goToMainMenu(){
        String menu = """
                1. Create Account
                2. Deposit
                3. Withdraw
                4. Check Balance
                5. Go to main menu
                6. Transfer
                7. Exit
                """;
        //input(menu);
        int userChoice = Integer.parseInt(input(menu + "please select"));
            switch (userChoice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    goToMainMenu();
                    break;
                case 6:
                    transfer();
                    break;
                case 7:
                    exitApplication();
                    break;
                default:
                    print("invalid choice please select again");
                    goToMainMenu();
        }
    }
}





