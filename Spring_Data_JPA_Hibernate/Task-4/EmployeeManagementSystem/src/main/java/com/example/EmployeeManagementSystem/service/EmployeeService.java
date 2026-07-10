package com.example.EmployeeManagementSystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.model.secondary.AuditLog;
import com.example.EmployeeManagementSystem.repository.primary.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.secondary.AuditLogRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AuditLogRepository auditLogRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Employee> getById(Long id) {
		return employeeRepository.findById(id);
	}

	@Transactional
	public Employee create(Employee employee) {
		Employee saved = employeeRepository.save(employee);
		logAudit("CREATE", "Created employee with id: " + saved.getId());
		return saved;
	}

	@Transactional
	public Employee update(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDepartment(employeeDetails.getDepartment());
		Employee updated = employeeRepository.save(employee);
		logAudit("UPDATE", "Updated employee with id: " + updated.getId());
		return updated;
	}

	@Transactional
	public void delete(Long id) {
		employeeRepository.deleteById(id);
		logAudit("DELETE", "Deleted employee with id: " + id);
	}

	@Transactional
	public void saveAllInBatches(List<Employee> employees) {
		int batchSize = 20;
		for (int i = 0; i < employees.size(); i++) {
			entityManager.persist(employees.get(i));
			if (i > 0 && i % batchSize == 0) {
				entityManager.flush();
				entityManager.clear();
			}
		}
		logAudit("BATCH_CREATE", "Bulk batch created " + employees.size() + " employees");
	}

	private void logAudit(String action, String details) {
		AuditLog log = new AuditLog();
		log.setAction(action);
		log.setDetails(details);
		log.setTimestamp(LocalDateTime.now());
		auditLogRepository.save(log);
	}
}
