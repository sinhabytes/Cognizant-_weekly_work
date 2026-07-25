package com.cognizant.comparison.hibernate;

import com.cognizant.comparison.model.Employee;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateEmployeeDAO(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    public Integer addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        }
        catch (HibernateException e) {
            if(tx != null) {
                tx.rollback();
            }
            
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return employeeID;
    }

    public Employee getEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }
}
