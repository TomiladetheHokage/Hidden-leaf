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
        Account newAccount = new Account(pin, generateAccountNumber(), accountName);
        accounts.add(newAccount);
        String aza = Integer.toString(generateAccountNumber());
        print(aza);
        noOfCustomers ++;
    }

    public void withdrawal(int amount, String pin, int accountNumber) {
            Account account = findAccount(accountNumber);
            if (account != null) {
                account.withdraw(amount, pin);
            } else {
                throw new IllegalArgumentException("Account not found. Unable to withdraw");
        }
    }

    public void print(String input){
        System.out.println(input);
    }


    public Account findAccount(int accountNumber) {
            for (Account account : accounts) {
                if (account.getAccountNumber() == (accountNumber)) {
                    return account;
                }
                else {throw new IllegalArgumentException("Account not found. Unable to find account");}
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
        }
        else {
            throw new IllegalArgumentException("Could not find account to transfer");}
    }

    private int generateAccountNumber(){
        return accounts.size() + 1;
    }

    public int checkBalanceFor(int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        if (account != null) {
            int balance;
            balance = account.checkBalance(pin);
            print("Your balance is "+ balance);
            return balance;
        }
        throw new IllegalArgumentException("Account not found. Unable to check balance");
    }

    public void depositTo (int accountNumber, int amount){
        Account account = findAccount(accountNumber);
        if (account != null){
            account.deposit(amount);
        }
        else {throw new IllegalArgumentException("Account not found. Unable to deposit");}
    }



}
