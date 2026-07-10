package com.example.EmployeeManagementSystem.repository.primary;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);

	List<Employee> findByEmailContaining(String domain);

	List<Employee> findByDepartmentId(Long departmentId);

	Employee findByEmail(@Param("email") String email);

	@Query("SELECT e FROM Employee e WHERE e.name = :name")
	List<Employee> searchByNameHql(@Param("name") String name);

	@Query("SELECT e FROM Employee e WHERE e.email LIKE %:email%")
	List<Employee> searchByEmailLikeHql(@Param("email") String email);

	@Query(value = "SELECT e.* FROM employee e JOIN department d ON e.department_id = d.id WHERE d.name = :deptName", nativeQuery = true)
	List<Employee> searchByDeptNameNative(@Param("deptName") String deptName);

	Page<Employee> findByNameContaining(String name, Pageable pageable);

	List<EmployeeProjection> findAllProjectedBy();

	List<EmployeeDto> findByDepartmentName(String deptName);
}
