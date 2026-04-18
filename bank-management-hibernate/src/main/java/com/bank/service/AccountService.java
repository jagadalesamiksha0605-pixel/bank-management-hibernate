package com.bank.service;

import com.bank.dao.AccountDao;
import com.bank.dao.TransactionDao;
import com.bank.dto.Account;

import java.time.LocalDateTime;
import java.util.List;

public class AccountService {

    AccountDao dao = new AccountDao();
    TransactionDao tdao = new TransactionDao(); // ✅ reuse

    // 🔹 Deposit
    public void deposit(int accountId, double amount) {

        // ✅ STEP 1: Validation (ADD HERE)
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        // ✅ STEP 2: Get Account
        Account acc = dao.getAccount(accountId);

        // ✅ STEP 3: Update Balance
        acc.setBalance(acc.getBalance() + amount);
        dao.updateAccount(acc);

        // ✅ STEP 4: Transaction (ALREADY EXISTS IN YOUR CODE)
        com.bank.dto.Transaction t = new com.bank.dto.Transaction();
        t.setType("DEPOSIT");
        t.setAmount(amount);
        t.setDate(java.time.LocalDateTime.now());
        t.setAccount(acc);

        tdao.saveTransaction(t);

        System.out.println("Amount deposited successfully!");
    }

    // 🔹 Withdraw
    public void withdraw(int accountId, double amount) {

        // ✅ STEP 1: Validation (ADD HERE)
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        // ✅ STEP 2: Get Account
        Account acc = dao.getAccount(accountId);

        // ✅ STEP 3: Balance Check
        if (acc.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        // ✅ STEP 4: Update Balance
        acc.setBalance(acc.getBalance() - amount);
        dao.updateAccount(acc);

        // ✅ STEP 5: Transaction (ALREADY EXISTS)
        com.bank.dto.Transaction t = new com.bank.dto.Transaction();
        t.setType("WITHDRAW");
        t.setAmount(amount);
        t.setDate(java.time.LocalDateTime.now());
        t.setAccount(acc);

        tdao.saveTransaction(t);

        System.out.println("Amount withdrawn successfully!");
    }
    
    public void checkBalance(int accountId) {
        Account acc = dao.getAccount(accountId);
        System.out.println("Current Balance: " + acc.getBalance());
    }

    // 🔹 View Transactions
    public void viewTransactions(int accountId) {

        List<com.bank.dto.Transaction> list = tdao.getTransactionsByAccount(accountId);

        if (list.isEmpty()) {
            System.out.println("No transactions found!");
            return;
        }

        for (com.bank.dto.Transaction t : list) {
            System.out.println(
                t.getId() + " | " +
                t.getType() + " | " +
                t.getAmount() + " | " +
                t.getDate()
            );
        }
    }
}