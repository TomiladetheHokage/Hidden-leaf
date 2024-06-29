package Banke;

public class Account {
    private int balance;
    private String pin;
    private int accountNumber;
    private String accountName;

    public Account(String pin, int accountNumber, String accountName) {
        this.balance = 0;
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
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be a positive number");
        }
        balance += amount;
    }

    public int checkBalance(String pin) {
        if (!this.pin.equalsIgnoreCase(pin)) {
            throw new IllegalArgumentException("Wrong pin");
        }
        return balance;
    }

    public void withdraw(int amount, String pin) {
        if(!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Wrong pin");
        }
        if (amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be above 0");
        }
        if (balance < amount){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;

    }
}
