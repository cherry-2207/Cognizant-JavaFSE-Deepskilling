package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START: getAllEmployees()");
        ArrayList<Employee> list = employeeDao.getAllEmployees();
        LOGGER.info("END: getAllEmployees()");
        return list;
    }

    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START: updateEmployee() for ID: {}", employee.getId());
        employeeDao.updateEmployee(employee);
        LOGGER.info("END: updateEmployee()");
    }

    @Transactional
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        LOGGER.info("START: deleteEmployee() for ID: {}", id);
        employeeDao.deleteEmployee(id);
        LOGGER.info("END: deleteEmployee()");
    }
}
