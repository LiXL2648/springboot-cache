package com.li.springboot.service.impl;

import com.li.springboot.bean.Employee;
import com.li.springboot.dao.EmployeeDao;
import com.li.springboot.service.EmployeeService;
import com.li.springboot.utils.DateTimeUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "employee"/*, cacheManager = "empRedisCacheManager"*/)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Cacheable(value = "employee",/*keyGenerator = "myKeyGenerator" */ key = "#id"
            , unless="#result == null"/*, condition = "#id != 20001"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询第" + id + "号员工");
        return employeeDao.getEmp(id);
    }

    @Override
    public List<Employee> getEmps() {
        return employeeDao.getEmps();
    }

    @Override
    public Employee addEmp(Employee emp) {
        employeeDao.addEmp(emp);
        return emp;
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeDao.deleteEmp(id);
    }

    @Override
    @Transactional
    @CachePut(value = "employee", key = "#emp.id")
    public Employee updateEmp(Employee emp) {
        System.out.println("修改第" + emp.getId() + "号员工");
        emp.setBirthday(DateTimeUtile.getDate("1996-05-04"));
        employeeDao.updateEmp(emp);
        // int i = 1 / 0;
        return emp;
    }
}
