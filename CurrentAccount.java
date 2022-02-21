package bank.account;

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
        this.balance += (amount - 1);
    }

    public void resetChecksUsed() {
        this.numberOfChecksUsed = 0;
    }

    public boolean withdrawUsingCheck(double amount) {
        if ((this.numberOfChecksUsed + 1) > 3) {
            if ((this.balance - (amount + 2)) > -11) {
                this.balance -= (amount + 2);
                this.numberOfChecksUsed += 1;
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