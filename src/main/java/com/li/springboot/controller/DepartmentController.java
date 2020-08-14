package com.li.springboot.controller;

import com.li.springboot.bean.Department;
import com.li.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("dep/{id}")
    public Department getDep(@PathVariable("id") Integer id) {
        return departmentService.getDep(id);
    }
}
