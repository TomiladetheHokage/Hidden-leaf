package Banke;

import java.util.Scanner;
public class Atm{

    private Bank kuda;

    public static String input(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void print(String prompt){
        System.out.print(prompt);
    }

    public static void exitApplication(){
        print("Exiting application");
    }

    public static void createAccount(){
        Bank kuda = new Bank();
        String name = input("What is your name? ");
        String pin = input("What is your pin? ");
        kuda.addCustomer(pin,name);
        print("Account succesfully created");
    }

    public static void deposit(){
        Bank kuda = new Bank();
        int accountNumber = Integer.parseInt(input("what is your account number? "));
        int amount = Integer.parseInt(input("How much do you want to deposit? "));
        kuda.depositTo(accountNumber, amount);

    }
    public static void main(String[] args){
print("hi");
    }
}

