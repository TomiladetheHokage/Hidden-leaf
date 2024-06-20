package Banke;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int noOfCustomers;

    public Bank(){
        accounts = new ArrayList<>();
        noOfCustomers = 0;
    }

    public void addCustomer(String pin, int accountNumber, String accountName) {
        Account newAccount = new Account(pin, accountNumber, accountName);
        accounts.add(newAccount);
        noOfCustomers ++;
    }

    public void withdrawal(int amount, String pin, int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount, pin);
            print("Amount succcesfully withdrawn");
        }
        else{
            print("Account not found");
        }
    }

    public void print(String input){
        System.out.println(input);
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) return account;
        }
        return null;
    }

    public int noOfCustomers(){
        return noOfCustomers;
    }

    public void transfer(int accountNumbertodeposit, int owneraccountNumber, int amount, String pin){
        Account account = findAccount(owneraccountNumber);
        if(account != null) {
            account.withdraw(amount, pin);
            depositTo(accountNumbertodeposit, amount);
            print("Amount successfully transfered");
        }
    }

    public void depositTo (int accountNumber, int amount){
        Account account = findAccount(accountNumber);
        if (account != null){
            account.deposit(amount);
            print("Amount succesfully deposited");
        }
        else { print("Account not found");}
    }

    public int checkBalanceFor(int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        if (account != null) {
            int balance;
            balance = account.checkBalance(pin);
            return balance;
        }
        else {
            print("Account not found");
            return 0;
        }
    }


}
