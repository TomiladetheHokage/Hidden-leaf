package Banke;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int noOfCustomers;

    //Account account = new Account("123",12,"ola");
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
        }
        //else{
        //    print("Account not found");
        //}

    }

    public void print(String input){
        System.out.println(input);
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) return account;
            else print("Account not found");
        }

        return null;
    }

    public int noOfCustomers(){
        return noOfCustomers;
    }

    public void depositTo (int accountNumber, int amount){
        Account account = findAccount(accountNumber);
        if (account != null){
            account.deposit(amount);
        }

    }


}
