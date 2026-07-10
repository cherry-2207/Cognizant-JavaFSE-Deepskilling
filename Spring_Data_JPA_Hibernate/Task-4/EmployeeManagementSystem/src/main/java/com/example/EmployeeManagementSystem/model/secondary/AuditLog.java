package com.example.EmployeeManagementSystem.model.secondary;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "audit_log")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "action", nullable = false)
	private String action;

	@Column(name = "details", nullable = false)
	private String details;

	@Column(name = "timestamp", nullable = false)
	private LocalDateTime timestamp;
}
