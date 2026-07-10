package com.cognizant.ormlearn.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllPermanentEmployees() {
		LOGGER.info("Start");
		return employeeRepository.getAllPermanentEmployees();
	}

	@Transactional(readOnly = true)
	public double getAverageSalary(int id) {
		LOGGER.info("Start");
		return employeeRepository.getAverageSalary(id);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployeesNative() {
		LOGGER.info("Start");
		return employeeRepository.getAllEmployeesNative();
	}
}
