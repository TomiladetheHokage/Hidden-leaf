package Banke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    public void testAccountCanCollectData(){
        Account account = new Account("123",1, "yemi");
        assertEquals(1,account.getAccountNumber());
        assertEquals("yemi", account.getaccountName());
    }

    @Test
    public void testAccountCanCheckBalance(){
        Account account = new Account("123",1, "yemi");
        assertEquals(0,account.checkBalance("123"));
        account.deposit(5_000);
        assertEquals( 5_000, account.checkBalance("123"));
    }

    @Test
    public void testAccountCanNotDepositNegativeBalance(){
        Account account = new Account("123",1, "yemi");
        account.deposit(-1_000);
        assertEquals(0, account.checkBalance("123"));
    }

    @Test
    public void testAccountCanDeposit(){
        Account account = new Account("123",1, "yemi");
        account.deposit(1_000);
        assertEquals(1_000, account.checkBalance("123"));
    }

    @Test
    public void testAccountCanWithdraw(){
        Account account = new Account("123",1, "yemi");
        account.deposit(1_000);
        account.withdraw(500, "123");
        assertEquals(500, account.checkBalance("111"));
    }

    @Test
    public void testAccountCanNotWithdraw0_00Balance(){
        Account account = new Account("123",1, "yemi");
        //account.deposit(1_000);
        account.withdraw(500, "123");
        assertEquals(0, account.checkBalance("111"));
    }

};