package com.example.EmployeeManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.repository.primary.EmployeeRepository;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		try {
			return ResponseEntity.ok(employeeService.update(id, employeeDetails));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/search")
	public Page<Employee> searchEmployees(
			@RequestParam String name,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "name,asc") String sort) {
		String[] sortParams = sort.split(",");
		Sort sortOrder = Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]);
		Pageable pageable = PageRequest.of(page, size, sortOrder);
		return employeeRepository.findByNameContaining(name, pageable);
	}

	@GetMapping("/projected")
	public List<EmployeeProjection> getProjectedEmployees() {
		return employeeRepository.findAllProjectedBy();
	}

	@GetMapping("/dto")
	public List<EmployeeDto> getDtoEmployeesByDept(@RequestParam String deptName) {
		return employeeRepository.findByDepartmentName(deptName);
	}

	@PostMapping("/batch")
	public ResponseEntity<Void> createEmployeesBatch(@RequestBody List<Employee> employees) {
		employeeService.saveAllInBatches(employees);
		return ResponseEntity.ok().build();
	}
}
