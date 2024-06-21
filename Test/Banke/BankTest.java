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
        kuda.withdrawal(500,"1",1);
        assertEquals(-1, kuda.checkBalanceFor(1, "1"));
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
        kuda.transfer(1,1,2_000,"123");
        assertEquals(-1, kuda.checkBalanceFor(1, "123"));
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
        kuda.depositTo(2, 5_000);
        assertEquals(-1, kuda.checkBalanceFor(2,"123"));
    }







}