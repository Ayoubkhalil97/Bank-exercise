package bank.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    CurrentAccount luke = new CurrentAccount("11458", 1300.50, 4);

    CurrentAccount rahul = new CurrentAccount("11459", 1500.50, 4);

    @Test
    void deposit() {

        Bank.deposit("11458", 250);

        assertEquals(1550.50, Bank.getBalance("11458"));

    }

    @Test
    void withdraw() {

        Bank.withdraw("11458", 300);

        assertEquals(1000.50, Bank.getBalance("11458"));

    }

    @Test
    void transfer() {

        Bank.transfer("11458", "11459", 200);

        assertEquals(1099.50, luke.getBalance());

    }
}