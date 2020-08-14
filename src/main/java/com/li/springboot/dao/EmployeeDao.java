package com.li.springboot.dao;

import com.li.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao {

    @Select("select * from employee where id = #{id}")
    Employee getEmp(Integer id);

    @Select("select * from employee")
    List<Employee> getEmps();

    @Insert("insert into employee(emp_name, email, gender, birthday, dep_id) values(" +
            "#{empName}, #{email}, #{gender}, #{birthday}, #{depId})")
    void addEmp(Employee emp);

    @Update("update employee set emp_name = #{empName}, email = #{email}, gender = #{gender}, " +
            "birthday = #{birthday}, dep_id = #{depId} where id = #{id}")
    void updateEmp(Employee emp);

    @Delete("delete from employee where id = #{id}")
    void deleteEmp(Integer id);
}
