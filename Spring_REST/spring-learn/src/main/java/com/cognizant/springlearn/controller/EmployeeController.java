package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;
import java.util.ArrayList;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START: getAllEmployees()");
        ArrayList<Employee> list = employeeService.getAllEmployees();
        LOGGER.info("END: getAllEmployees()");
        return list;
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START: updateEmployee() for ID: {}", employee.getId());
        employeeService.updateEmployee(employee);
        LOGGER.info("END: updateEmployee()");
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        LOGGER.info("START: deleteEmployee() for ID: {}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END: deleteEmployee()");
    }
}
