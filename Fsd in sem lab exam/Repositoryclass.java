package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDemo
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Booking.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert Records
        Booking b1 = new Booking("Prasad","12-03-2026","Confirmed");
        Booking b2 = new Booking("Ravi","15-03-2026","Pending");

        session.save(b1);
        session.save(b2);

        tx.commit();

        System.out.println("Records Inserted Successfully");

        // HQL Query to View All Records
        session.beginTransaction();

        Query q = session.createQuery("from Booking");
        List<Booking> list = q.list();

        for(Booking b : list)
        {
            System.out.println("ID : " + b.getId());
            System.out.println("Name : " + b.getName());
            System.out.println("Date : " + b.getDate());
            System.out.println("Status : " + b.getStatus());
            System.out.println("-------------------");
        }

        session.close();
        sf.close();
    }
}