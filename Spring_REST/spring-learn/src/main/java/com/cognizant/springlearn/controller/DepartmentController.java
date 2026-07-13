package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.service.DepartmentService;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("START: getAllDepartments()");
        ArrayList<Department> list = departmentService.getAllDepartments();
        LOGGER.info("END: getAllDepartments()");
        return list;
    }
}
