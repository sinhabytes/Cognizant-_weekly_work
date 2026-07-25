package com.cognizant.hibernate;

import com.cognizant.hibernate.dao.EmployeeDAO;
import com.cognizant.hibernate.model.Employee;
import com.cognizant.hibernate.util.HibernateUtil;

import java.util.List;

public class App {

    private static final EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        try {
            Employee emp1 = new Employee("Kalyan Ranjan", 200000);
            Employee emp2 = new Employee("Aditya Ranjan", 500000);

            testSaveEmployee(emp1);
            testSaveEmployee(emp2);

            testGetAllEmployees();

            if(emp1.getId() > 0) {
                testGetEmployeeById(emp1.getId());
                testUpdateEmployee(emp1.getId(), 800000);
                testDeleteEmployee(emp2.getId());
            }

            testGetAllEmployees();
        }
        finally {
            HibernateUtil.shutdown();
        }
    }

    private static void testGetAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        System.out.println("Employees = " + employees);
    }

    private static void testGetEmployeeById(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        System.out.println("Employee = " + employee);
    }

    private static void testSaveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
        System.out.println("Saved Employee = " + employee);
    }

    private static void testUpdateEmployee(int id, double newSalary) {
        employeeDAO.updateEmployee(id, newSalary);
        System.out.println("Employee Updated Successfully");
    }

    private static void testDeleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
        System.out.println("Employee Deleted Successfully");
    }
}
