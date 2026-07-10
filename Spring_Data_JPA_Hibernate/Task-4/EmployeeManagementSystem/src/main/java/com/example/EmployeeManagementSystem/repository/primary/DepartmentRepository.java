package com.example.EmployeeManagementSystem.repository.primary;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EmployeeManagementSystem.model.primary.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByName(String name);
}
