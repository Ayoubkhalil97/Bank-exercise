package bank.account;

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