package Banke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void testBankCanAddCustomer(){
        Bank kuda = new Bank();
        kuda.addCustomer("1",12,"yemi");
        assertEquals(1, kuda.noOfCustomers());
    }

    @Test
    public void testBankCanNotWithdrawFromNonExistingAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("1",12,"tomi");
        kuda.depositTo(11, 2_000);
        kuda.withdrawal(500,"1",11);
        assertEquals(0, kuda.checkBalanceFor(12, "1"));
    }

    @Test
    public void testBankCanWithdraw(){
        Bank kuda = new Bank();
        kuda.addCustomer("1",12,"yemi");
        kuda.depositTo(12, 5_000);
        kuda.withdrawal(2_000, "1", 12);
        assertEquals(3_000, kuda.checkBalanceFor(12, "1"));
    }

    @Test
    public void testBankCanFindAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("1",12,"tomi");
        Account foundAccount = kuda.findAccount(12);
        assertEquals(12, foundAccount.getAccountNumber());
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
        kuda.addCustomer("123",12,"wade");
        kuda.depositTo(12, 5_000);

        kuda.addCustomer("1234", 11, "sade");
        kuda.transfer(11,12,2_000,"123");
        assertEquals(2_000, kuda.checkBalanceFor(11, "123"));
    }

    @Test
    public void testBankCanDeposit(){
        Bank kuda = new Bank();
        kuda.addCustomer("123",13,"Tomi");
        kuda.depositTo(13,5_000);
        assertEquals(5_000, kuda.checkBalanceFor(13, "123"));
    }

    @Test
    public void testBankkCanNotDepositToNonExistingAccount(){
        Bank kuda = new Bank();
        kuda.addCustomer("123",13,"Tomi");
        kuda.depositTo(1, 5_000);
        assertEquals(0, kuda.checkBalanceFor(1,"123"));
    }





}