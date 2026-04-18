package com.bank.main;

import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dto.Account;
import com.bank.dto.Customer;
import com.bank.service.AccountService;

public class BankDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();
        AccountDao dao = new AccountDao();

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Customer & Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Email: ");
                    String email = sc.next();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Customer c = new Customer();
                    c.setName(name);
                    c.setEmail(email);

                    Account acc = new Account();
                    acc.setBalance(balance);
                    acc.setCustomer(c);

                    int accId = dao.saveAccount(acc);

                    System.out.println("Account created! ID: " + accId);
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int depId = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depAmt = sc.nextDouble();

                    service.deposit(depId, depAmt);
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int witId = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double witAmt = sc.nextDouble();

                    service.withdraw(witId, witAmt);
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    int balId = sc.nextInt();

                    service.checkBalance(balId);
                    break;
                    
                case 5:
                    System.out.print("Enter Account ID: ");
                    int accIdView = sc.nextInt();

                    service.viewTransactions(accIdView);
                    break;
                    
                case 6:
                	System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}