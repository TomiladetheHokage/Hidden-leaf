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
        kuda.withdrawal(500,"1",11);

        Account accountNotFound = kuda.findAccount(11);
        assertEquals(null, accountNotFound);
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



}