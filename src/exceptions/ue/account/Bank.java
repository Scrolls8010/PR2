package exceptions.ue.account;

import java.util.HashMap;

public class Bank {

    private HashMap <String, Account> accounts;

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount (String owner, double balance, double overDraftLimit) throws BankException {
        if (accounts.containsKey(owner)) {
            throw new BankException("Account already exists!");
        } else {
            accounts.put(owner,new Account(owner,balance,overDraftLimit));
        }
    }

    public void transferMoney (String senderAccount, String receiverAccount, double amount)
            throws AccountNotFoundException, BankException {
        if (!accounts.containsKey(senderAccount) || (!accounts.containsKey(receiverAccount))) {
            throw new AccountNotFoundException("Account not found!!");
        }
        try {
            accounts.get(senderAccount).debit(amount);
            accounts.get(receiverAccount).credit(amount);
        } catch (NotEnoughMoneyException e) {
            throw new BankException("Transfer failed", e);
        }

    }


}
