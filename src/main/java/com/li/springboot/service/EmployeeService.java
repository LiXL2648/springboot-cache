package com.li.springboot.service;

import com.li.springboot.bean.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmp(Integer id);

    List<Employee> getEmps();

    Employee addEmp(Employee emp);

    Employee updateEmp(Employee emp);

    void deleteEmp(Integer id);
}
