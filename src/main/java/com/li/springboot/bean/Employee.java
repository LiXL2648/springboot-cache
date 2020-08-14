package com.li.springboot.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;
    private String empName;
    private String email;
    private Integer gender;
    private Date birthday;
    private Integer depId;

    public Employee(String empName, String email, Integer gender, Date birthday, Integer depId) {
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", depId=" + depId +
                '}';
    }
}
