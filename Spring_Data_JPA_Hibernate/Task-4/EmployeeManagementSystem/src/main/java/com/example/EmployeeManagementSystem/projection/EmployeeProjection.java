package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

	Long getId();

	String getName();

	String getEmail();

	@Value("#{target.department.name}")
	String getDepartmentName();
}
