package com.cognizant.comparison.service;

import com.cognizant.comparison.model.Employee;
import com.cognizant.comparison.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
