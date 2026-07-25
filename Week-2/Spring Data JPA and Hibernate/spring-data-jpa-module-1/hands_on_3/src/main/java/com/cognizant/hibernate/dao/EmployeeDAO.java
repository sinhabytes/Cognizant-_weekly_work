package com.cognizant.hibernate.dao;

import com.cognizant.hibernate.model.Employee;
import com.cognizant.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("FROM Employee", Employee.class).list();
        session.close();
        return list;
    }

    public Employee getEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public void saveEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(employee);
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

    public void updateEmployee(int id, double newSalary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);

            if(employee != null) {
                employee.setSalary(newSalary);
            }

            tx.commit();
        }
        catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            throw e;
        }
        finally {
            session.close();
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);

            if(employee != null) {
                session.delete(employee);
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
