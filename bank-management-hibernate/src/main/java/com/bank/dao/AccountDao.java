package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.db.HibernateUtil;
import com.bank.dto.Account;

public class AccountDao {

	public int saveAccount(Account account) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    int id = (int) session.save(account);

	    tx.commit();
	    session.close();

	    return id;
	}
    
    public Account getAccount(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account acc = session.get(Account.class, id);
        session.close();
        return acc;
    }

    public void updateAccount(Account acc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(acc);

        tx.commit();
        session.close();
    }
}