package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static CountryRepository countryRepository;
	private static StockRepository stockRepository;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		countryRepository = context.getBean(CountryRepository.class);
		stockRepository = context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		LOGGER.info("Inside main");

		testCountryQueryMethods();
		testStockQueryMethods();
		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
	}

	private static void testCountryQueryMethods() {
		LOGGER.info("Start country queries");
		List<Country> countriesContains = countryRepository.findByNameContainingOrderByNameAsc("ou");
		LOGGER.debug("countries contains 'ou' (asc): {}", countriesContains);

		List<Country> countriesStarts = countryRepository.findByNameStartingWith("Z");
		LOGGER.debug("countries starting with 'Z': {}", countriesStarts);
		LOGGER.info("End country queries");
	}

	private static void testStockQueryMethods() {
		LOGGER.info("Start stock queries");
		Date start = parseDate("2019-09-01");
		Date end = parseDate("2019-09-30");
		List<Stock> fbSeptember = stockRepository.findByCodeAndDateBetween("FB", start, end);
		LOGGER.debug("FB September 2019: {}", fbSeptember);

		List<Stock> googlHigh = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
		LOGGER.debug("GOOGL close > 1250: {}", googlHigh);

		List<Stock> topVolume = stockRepository.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("Top 3 volume: {}", topVolume);

		List<Stock> lowestNflx = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
		LOGGER.debug("Top 3 lowest NFLX close: {}", lowestNflx);
		LOGGER.info("End stock queries");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start get employee");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End get employee");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start add employee");
		Employee employee = new Employee();
		employee.setName("John Doe");
		employee.setSalary(45000.0);
		employee.setPermanent(true);
		employee.setDateOfBirth(parseDate("1995-05-15"));
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Added Employee: {}", employee);
		LOGGER.info("End add employee");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start update employee");
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Updated Employee: {}", employee);
		LOGGER.info("End update employee");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start get department");
		Department department = departmentService.get(1);
		LOGGER.debug("Department: {}", department);
		LOGGER.debug("Department Employees: {}", department.getEmployeeList());
		LOGGER.info("End get department");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start add skill to employee");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.debug("Employee Skills After Save: {}", employee.getSkillList());
		LOGGER.info("End add skill to employee");
	}

	private static Date parseDate(String dateStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}
}
