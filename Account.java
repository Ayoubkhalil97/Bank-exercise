package bank.account;
import  bank.account.Bank;

public abstract class Account {
    public String accountID;
    public Double balance;

    public Account(String accountID, Double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String toString() {
        return "accountID=" + this.accountID + ", Balance=" + this.balance;
    }

    public abstract boolean withdraw(double amount);

    public abstract void deposit(double amount);

}










