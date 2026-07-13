package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        LOGGER.info("START: Loading departmentList bean in DepartmentDao constructor");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", ArrayList.class);
        LOGGER.info("END: DepartmentDao constructor complete. Total departments loaded: {}", DEPARTMENT_LIST.size());
    }

    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("START: getAllDepartments()");
        LOGGER.info("END: getAllDepartments()");
        return DEPARTMENT_LIST;
    }
}
