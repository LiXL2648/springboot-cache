package com.li.springboot.service.impl;

import com.li.springboot.bean.Department;
import com.li.springboot.dao.DepartmentDao;
import com.li.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "department", cacheManager = "depRedisCacheManager")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Cacheable(value = "department", key = "#depId")
    public Department getDep(Integer depId) {
        return departmentDao.getDep(depId);
    }

    @Override
    public List<Department> getDeps() {
        return departmentDao.getDeps();
    }

    @Override
    public Department addDep(Department dep) {
        departmentDao.addDep(dep);
        return dep;
    }

    @Override
    public Department updateDep(Department dep) {
        departmentDao.updateDep(dep);
        return dep;
    }

    @Override
    public void deleteDep(Integer id) {
        departmentDao.deleteDep(id);
    }
}
