package com.cognizant.hibernate.dao;

import com.cognizant.hibernate.model.Country;
import com.cognizant.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDAO {

    public List<Country> getAllCountries() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Country> list = session.createQuery("FROM Country", Country.class).list();
        session.close();
        return list;
    }

    public Country getCountryByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = session.get(Country.class, code);
        session.close();
        return country;
    }

    public void saveCountry(Country country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(country);
            tx.commit();
        }
        catch(Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }

    public void updateCountry(String code, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Country country = session.get(Country.class, code);

            if(country != null) {
                country.setName(newName);
            }

            tx.commit();
        }
        catch(Exception e) {
            if(tx != null) {
                tx.rollback();
            }

            throw e;
        }
        finally {
            session.close();
        }
    }

    public void deleteCountry(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Country country = session.get(Country.class, code);

            if(country != null) {
                session.delete(country);
            }

            tx.commit();
        }
        catch(Exception e) {
            if(tx != null) {
                tx.rollback();
            }

            throw e;
        }
        finally {
            session.close();
        }
    }
}
