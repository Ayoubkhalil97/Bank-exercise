package bank.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    SavingAccount solomon = new SavingAccount("5413", 1300.0);


    @Test
    void withdraw() {

        solomon.withdraw(200);

        assertEquals(1107, solomon.getBalance());
    }

    @Test
    void deposit() {

        solomon.deposit(150);

        assertEquals(1460, solomon.getBalance());

    }

    @Test
    void addInterest() {

        solomon.addInterest(3);

        assertEquals(1865.21484375,  solomon.getBalance());

    }

    @Test
    void testToString() {

        assertEquals("accountID=5413, Balance=1310.0 , Interest Rate=0.125%", solomon.toString());
    }
}