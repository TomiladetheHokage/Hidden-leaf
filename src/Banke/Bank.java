package Banke;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int noOfCustomers;

    Account account = new Account("123",12,"ola");
    public Bank(){
        accounts = new ArrayList<>();
        noOfCustomers = 0;
    }

    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    public void addCustomer(String pin, String accountName, String accountNumber){
        Account newAccount = new Account("123",12,"ola");
        accounts.add(newAccount);
        noOfCustomers ++;
    }


    public void withdrawFrom(int amount, String pin) {
        Account account = new Account("1",1,"12");
        account.withdraw(amount, pin);
    }

    public int balanceCheck(String pin){
        Account account = new Account("123",12,"ola");
        return account.checkBalance(pin);
       // return 0;
        //return 0;
    }
}
