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
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static CountryRepository countryRepository;
	private static StockRepository stockRepository;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static AttemptService attemptService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		countryRepository = context.getBean(CountryRepository.class);
		stockRepository = context.getBean(StockRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		attemptService = context.getBean(AttemptService.class);

		LOGGER.info("Inside main");

		testCountryQueryMethods();
		testStockQueryMethods();
		testGetAllPermanentEmployees();
		testQuizAttempt();
		testGetAverageSalary();
		testGetAllEmployeesNative();
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

	private static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	private static void testQuizAttempt() {
		LOGGER.info("Start");
		Attempt attempt = attemptService.getAttempt(1, 1);
		if (attempt != null) {
			for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
				Question q = aq.getQuestion();
				LOGGER.debug("{}", q.getText());
				int count = 1;
				for (Option o : q.getOptions()) {
					boolean selected = false;
					for (AttemptOption ao : aq.getAttemptOptions()) {
						if (ao.getOption().getId() == o.getId()) {
							selected = ao.isSelected();
							break;
						}
					}
					LOGGER.debug(" {}) {} \t {}\t {}", count++, o.getText(), o.getScore(), selected);
				}
			}
		}
		LOGGER.info("End");
	}

	private static void testGetAverageSalary() {
		LOGGER.info("Start");
		double avg = employeeService.getAverageSalary(1);
		LOGGER.debug("Average Salary: {}", avg);
		LOGGER.info("End");
	}

	private static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> list = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees Native: {}", list);
		LOGGER.info("End");
	}

	private static Date parseDate(String dateStr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}
}
