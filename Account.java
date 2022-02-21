package bank.account;
import  bank.account.Bank;



public abstract class Account {
    public String accountID;
    public Double balance;

    public Account(String accountID, Double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }
    public String toString(){
            return "accountID=" + this.accountID + ", Balance=" + this.balance;
    }

    public abstract boolean withdraw (double amount);

    public abstract void deposit (double amount);

}

class SavingAccount extends Account {


    public SavingAccount(String accountID, Double balance, Double interestRate) {
        super(accountID, balance);
        if (balance > 1000) {
          this.balance = balance + 10.00;
        }
        Bank.listOFAccounts.add(new SavingAccount(accountID, balance, interestRate));
    }



    @Override
    public boolean withdraw(double amount) {
       if ((this.balance-amount-3.0)>=10.0) {
           this.balance-=(amount+3);
           return true;
       } else {
           return false;
       }
    }

    @Override
    public void deposit(double amount) {
        this.balance+= amount;
    }



    public Double addInterest(int ratePeriod){
        double rate = Bank.savingsInterestRate;
        Double effectiveRate = (Math.pow((1.00+rate), ratePeriod)-1);
        Double paidInterest = effectiveRate*this.balance;
        this.balance+=paidInterest;
        return paidInterest;
    }

    @Override
    public String toString() {
        return super.toString() + ", Interest Rate=" + Bank.savingsInterestRate + "%";
    }
}

class CurrentAccount extends Account {
    public int numberOfChecksUsed;

    public CurrentAccount(String accountID, Double balance, int numberOfChecksUsed) {
        super(accountID, balance);
        this.numberOfChecksUsed = numberOfChecksUsed;
        Bank.listOFAccounts.add(new CurrentAccount(accountID, balance, numberOfChecksUsed));
    }

    @Override
    public boolean withdraw(double amount) {
        if ((this.balance - amount) > 0) {
            this.balance -= (amount + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        this.balance +=(amount - 1);
    }

    public void resetChecksUsed() {
        this.numberOfChecksUsed = 0;
    }

    public boolean withdrawUsingCheck(double amount) {
        if ((this.numberOfChecksUsed + 1) > 3) {
            if ((this.balance - (amount + 2)) > -11) {
                this.balance -=(amount + 2);
                this.numberOfChecksUsed +=1;
                return true;
            } else {
                return false;
            }

        } else {
            if (this.balance - amount > -11) {
                this.balance -= amount;
                this.numberOfChecksUsed += 1;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Number of checks=" + this.numberOfChecksUsed;
    }

}





