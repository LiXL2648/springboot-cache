package com.li.springboot.service;

import com.li.springboot.bean.Department;

import java.util.List;

public interface DepartmentService {

    Department getDep(Integer depId);

    List<Department> getDeps();

    Department addDep(Department dep);

    Department updateDep(Department dep);

    void deleteDep(Integer id);
}
