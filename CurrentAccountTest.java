package bank.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrentAccountTest {

    CurrentAccount nathan = new CurrentAccount("11497", 1200.50, 5);

    @Test
    void deposit() {

        nathan.deposit(500);

        assertEquals(1699.50, nathan.getBalance());
    }

    @Test
    void withdraw() {

        nathan.withdraw(200);

        assertEquals(999.50, nathan.getBalance());

    }

    @Test
    void testToString() {

        assertEquals("accountID=11497, Balance=1200.5, Number of checks=5", nathan.toString());
    }
}