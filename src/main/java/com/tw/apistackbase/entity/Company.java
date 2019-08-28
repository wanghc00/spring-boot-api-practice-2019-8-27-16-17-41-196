/*
 * Copyright (C), 1992-2019
 * Package com.tw.apistackbase.entity 
 * FileName: Company.java
 * Author:   wang-hc
 * Date:     2019年8月28日 下午5:43:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 *===============================================================================================
 *   author：          time：                             version：           desc：
 *   wang-hc           2019年8月28日下午5:43:26                     1.0                  
 *===============================================================================================
 */
package com.tw.apistackbase.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String id;
    private List<Employee> employees = new ArrayList<Employee>();
    
    Company(){}

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    
}
