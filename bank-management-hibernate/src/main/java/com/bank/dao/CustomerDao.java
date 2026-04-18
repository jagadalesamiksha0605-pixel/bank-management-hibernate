package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.db.HibernateUtil;
import com.bank.dto.Customer;

public class CustomerDao {

    public void saveCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();
    }
}