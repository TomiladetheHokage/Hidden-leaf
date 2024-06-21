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
        if (amount > 0){
            balance = balance + amount;
        }
    }

    public int checkBalance(String pin){
    if (this.pin.equalsIgnoreCase(pin)){
        return balance;
    }
   else{
       Bank bank = new Bank();
       bank.print("Wrong Pin");
       return -1;
   }
    }


    public void withdraw(int amount, String pin) {
    if(this.pin.equalsIgnoreCase(pin)){
        if (balance > amount && amount > 0){
            balance = balance - amount;
        }
    }

     
    }
}
