package Banke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void testBankCanAddCustomer(){
        Bank kuda = new Bank();
        kuda.addCustomer("1","yemi");
        assertEquals(1, kuda.noOfCustomers());
        kuda.addCustomer("1","wade");
        assertEquals(2, kuda.noOfCustomers());
    }

    @Test
    public void testBankCanNotWithdrawFromNonExistingAccount(){
        Bank kuda = new Bank();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->kuda.withdrawal(500,"1",12));
        assertEquals("Account not found. Unable to withdraw", exception.getMessage());
    }

    @Test
    public void testBankCanWithdraw(){
        Bank kuda = new Bank();
        kuda.addCustomer("1","yemi");
        kuda.depositTo(1, 5_000);
        kuda.withdrawal(2_000, "1", 1);
        assertEquals(3_000, kuda.checkBalanceFor(1, "1"));
    }

    @Test
    public void testBankCanFindAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("1","tomi");
        Account foundAccount = kuda.findAccount(1);
        assertEquals(1, foundAccount.getAccountNumber());
        assertEquals("tomi", foundAccount.getaccountName());
    }

    @Test
    public void testNumberOfCustomersCanCount(){
        Bank kuda = new Bank();
        assertEquals(0, kuda.noOfCustomers());
    }

    @Test
    public void testBankCanTransfer(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","wade");
        kuda.depositTo(1, 5_000);

        kuda.addCustomer("1234",  "sade");
        kuda.transfer(2,1,2_000,"123");
        assertEquals(3_000, kuda.checkBalanceFor(1, "123"));
        assertEquals(2_000, kuda.checkBalanceFor(2, "1234"));
    }

    @Test
    public void testBankCanNotTransferToNonExistingAza(){
        Bank kuda = new Bank();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->kuda.transfer(1, 2,2_000,"123"));
        assertEquals("Could not find account to transfer", exception.getMessage());
    }

    @Test
    public void testBankCanDeposit(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","Tomi");
        kuda.depositTo(1,5_000);
        assertEquals(5_000, kuda.checkBalanceFor(1, "123"));
    }

    @Test
    public void testBankkCanNotDepositToNonExistingAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","Tomi");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->kuda.depositTo(2, 5_000));
        assertEquals("Account not found. Unable to deposit", exception.getMessage());
    }

    @Test
    public void testBankCanNotWithdrawMoreThanAccountBalance(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","Tomi");
        kuda.depositTo(1,1_000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->kuda.withdrawal(2_000, "123",1));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    public void testBankCanNotCheckBalanceOfNonExistingAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","Tomi");
        kuda.depositTo(1,1_000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->kuda.checkBalanceFor(2, "123"));
        assertEquals("Account not found. Unable to check balance", exception.getMessage());
    }

    @Test
    public void testBankCanCheckBalance(){
        Bank kuda = new Bank();
        kuda.addCustomer("123","Tomi");
        kuda.depositTo(1,1_000);
        assertEquals(1_000, kuda.checkBalanceFor(1, "123"));
    }






}