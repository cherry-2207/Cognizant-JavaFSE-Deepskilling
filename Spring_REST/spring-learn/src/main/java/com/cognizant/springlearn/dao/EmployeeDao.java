package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("START: Loading employee.xml beans in EmployeeDao constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
        LOGGER.info("END: EmployeeDao constructor complete. Total employees loaded: {}", EMPLOYEE_LIST.size());
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START: getAllEmployees()");
        LOGGER.info("END: getAllEmployees()");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START: updateEmployee() for ID: {}", employee.getId());
        boolean found = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                found = true;
                break;
            }
        }
        if (!found) {
            LOGGER.error("Employee with ID: {} not found for update", employee.getId());
            throw new EmployeeNotFoundException();
        }
        LOGGER.info("END: updateEmployee() success");
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        LOGGER.info("START: deleteEmployee() for ID: {}", id);
        boolean found = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == id) {
                EMPLOYEE_LIST.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            LOGGER.error("Employee with ID: {} not found for delete", id);
            throw new EmployeeNotFoundException();
        }
        LOGGER.info("END: deleteEmployee() success");
    }
}
