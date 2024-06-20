package Banke;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int noOfCustomers;

    public Bank(){
        accounts = new ArrayList<>();
        noOfCustomers = 0;
    }

    public void addCustomer(String pin, String accountName) {
        int accountNumber = generateAccountNumber();
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
            print("Account not found. Unable to withdraw");
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

    public void transfer(int destinationAcc, int owneraccountNumber, int amount, String pin){
        Account Ownaccount = findAccount(owneraccountNumber);
        Account destinationAccount = findAccount(destinationAcc);
        if(Ownaccount != null && destinationAccount != null) {
            Ownaccount.withdraw(amount, pin);
            depositTo(destinationAcc, amount);
            print("Amount successfully transfered");
        }
        else { print("Could not find account to transfer");}
    }

    public void depositTo (int accountNumber, int amount){
        Account account = findAccount(accountNumber);
        if (account != null){
            account.deposit(amount);
            print("Amount succesfully deposited");
        }
        else { print("Account not found. Can not deposit");}
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
            return -1;
        }
    }

    private int generateAccountNumber(){
        return accounts.size() + 1;
    }

}
