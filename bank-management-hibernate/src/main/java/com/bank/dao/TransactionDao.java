package com.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bank.db.HibernateUtil;

public class TransactionDao {

    public void saveTransaction(com.bank.dto.Transaction t) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(t);

        tx.commit();
        session.close();
    }

    public List<com.bank.dto.Transaction> getTransactionsByAccount(int accountId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<com.bank.dto.Transaction> query =
                session.createQuery(
                        "from Transaction where account.accountId = :id",
                        com.bank.dto.Transaction.class
                );

        query.setParameter("id", accountId);

        List<com.bank.dto.Transaction> list = query.getResultList();

        session.close();

        return list;
    }
}