package Banke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    public void testNumberOfCustomersCanCount(){
        Bank kuda = new Bank();
        assertEquals(0, kuda.getNoOfCustomers());
    }

    @Test
    public void testBankCanAddCustomer(){
        Bank kuda = new Bank();
        kuda.addCustomer("1","tomi","12");
        assertEquals(1, kuda.getNoOfCustomers());
    }

    @Test
    public void testBankCanWithdraw(){
        Bank kuda = new Bank();
        kuda.addCustomer("1","tomi","12");
        kuda.withdrawFrom(500,"12");
        assertEquals(0, kuda.balanceCheck("1"));
    }



}