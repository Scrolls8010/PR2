package exceptions.ue.account;

import java.util.HashMap;

public class BankDemo {

    public static void main(String[] args) {

        Account account1 = new Account("Lukas Reisinger", 1000.0, 300.0);

        System.out.println(account1.toString());
        account1.credit(550);
        try {
            account1.debit(100);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        try {
            account1.debit(200);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        try {
            account1.debit(500);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }


        try {
            account1.debit(1000);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        try {
            account1.debit(20);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        account1.credit(2000);

        Bank raika = new Bank(new HashMap<>());

        try {
            raika.addAccount("Gerald Reisinger", 20_000, 1000);
        } catch (BankException e) {
            e.printStackTrace();
        }

        try {
            raika.addAccount("Markus Reisinger", 10_000, 1000);
        } catch (BankException e) {
            e.printStackTrace();
        }

        try {
            raika.transferMoney("Gerald Reisinger", "Markus Reisinger", 1000);
        } catch (AccountNotFoundException | BankException e) {
            e.printStackTrace();
        }

        try {
            raika.transferMoney("Markus Reisinger", "Gerald Reisinger", 100_000);
        } catch (AccountNotFoundException | BankException e) {
            e.printStackTrace();
        }


    }



}
