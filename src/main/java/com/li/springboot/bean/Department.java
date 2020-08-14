package com.li.springboot.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

    private Integer depId;
    private String depName;
    private String city;

    public Department(String depName, String city) {
        this.depName = depName;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
