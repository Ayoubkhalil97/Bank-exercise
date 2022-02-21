package bank.account;

import java.util.ArrayList;
import bank.account.Account;

public class Bank {
    public String name;
    public static double savingsInterestRate;
    static ArrayList<Account> listOFAccounts;


    public boolean deposit(String accountID, double amount) {
        for (Account account : this.listOFAccounts) {
            if (account.accountID == accountID) {
                account.balance += amount;
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(String accountID, double amount) {
        for (Account account : this.listOFAccounts) {
            if (account.accountID == accountID) {
                account.balance -= amount;
                return true;
            }
        }
        return false;
    }


    public boolean transfer(String fromAccountID, String toAccountID, double amount) {
        for (Account fromaccount : this.listOFAccounts) {
            if (fromaccount.accountID == fromAccountID) {
                for (Account toaccount : this.listOFAccounts) {
                    if (toaccount.accountID == toAccountID) {
                        fromaccount.withdraw(amount);
                        toaccount.deposit(amount);
                    }

                }
            }
        }
        return false;

    }
}

