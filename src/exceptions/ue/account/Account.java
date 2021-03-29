package exceptions.ue.account;

public class Account {

    private String owner;
    private double balance;
    private double overDraftLimit;

    public Account(String owner, double balance, double overDraftLimit) {
        this.owner = owner;
        this.balance = balance;
        this.overDraftLimit = overDraftLimit;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void credit (double amount) {
        this.balance = this.balance + amount;
        System.out.println("Balance update for " + this.owner +   "New Balance : " + this.balance);
    }

    public void debit (double amount) throws NotEnoughMoneyException {
        if ((balance + overDraftLimit) > amount) {
            this.balance -= amount;
            System.out.println("Balance update for " + this.owner +   "New Balance : " + this.balance);
        } else {
            throw new NotEnoughMoneyException("Balance too low!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                ", overDraftLimit=" + overDraftLimit +
                '}';
    }
}
