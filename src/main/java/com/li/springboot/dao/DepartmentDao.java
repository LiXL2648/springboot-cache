package com.li.springboot.dao;

import com.li.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    Department getDep(Integer depId);

    List<Department> getDeps();

    void addDep(Department dep);

    void updateDep(Department dep);

    void deleteDep(Integer id);
}
