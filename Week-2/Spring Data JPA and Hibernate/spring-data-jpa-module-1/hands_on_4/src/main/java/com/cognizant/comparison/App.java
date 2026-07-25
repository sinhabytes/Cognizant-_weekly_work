package com.cognizant.comparison;

import com.cognizant.comparison.hibernate.HibernateEmployeeDAO;
import com.cognizant.comparison.model.Employee;
import com.cognizant.comparison.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    private static EmployeeService employeeService;
    private static HibernateEmployeeDAO hibernateEmployeeDAO;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        employeeService = context.getBean(EmployeeService.class);

        hibernateEmployeeDAO = context.getBean(HibernateEmployeeDAO.class);

        testHibernateApproach();

        testSpringDataJpaApproach();
    }

    private static void testHibernateApproach() {
        Employee emp = new Employee("Aditya Ranjan", 50000.0);

        Integer id = hibernateEmployeeDAO.addEmployee(emp);

        System.out.println("Saved Via Hibernate, id = " + id);

        Employee saved = hibernateEmployeeDAO.getEmployee(id);

        System.out.println("Fetched Via Hibernate = " + saved);
    }

    private static void testSpringDataJpaApproach() {
        Employee emp = new Employee("Kalyan Ranjan", 60000.0);

        employeeService.addEmployee(emp);

        System.out.println("Saved Via Spring Data JPA, id = " + emp.getId());

        Employee saved = employeeService.getEmployee(emp.getId());
        
        System.out.println("Fetched Via Spring Data JPA = " + saved);
    }
}
