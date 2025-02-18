package controller;

import java.util.List;

import model.Transaction;

public class AccountController {

	private List<Transaction> transactions;

    public AccountController(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance(String accountNumber) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAcount_number().equals(accountNumber)) {
                balance += transaction.getTransaction_amount();
            }
        }
        return balance;
    }  
}
