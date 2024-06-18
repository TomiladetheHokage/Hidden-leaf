package Banke;

public class Account {
    private int balance;
    private String pin;
    private int accountNumber;
    private String accountName;

public Account(String pin, int accountNumber, String accountName) {
    this.balance = balance;
    this.pin = pin;
    this.accountNumber = accountNumber;
    this.accountName = accountName;
}
    public String getaccountName(){
        return accountName;
    }

    public int getAccountNumber () {
    return accountNumber;
    }

    public void deposit(int amount){
        if (amount > 0){
            balance = balance + amount;
        }
    }

    public int checkBalance(String pin){
    return balance;
    }


    public void withdraw(int amount, String pin) {
    if (balance > amount && amount > 0){
        balance = balance - amount;
    }
     
    }
}
