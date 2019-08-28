/*
 * Copyright (C), 1992-2019
 * Package com.tw.apistackbase.entity 
 * FileName: Employee.java
 * Author:   wang-hc
 * Date:     2019年8月28日 下午5:46:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 *===============================================================================================
 *   author：          time：                             version：           desc：
 *   wang-hc           2019年8月28日下午5:46:14                     1.0                  
 *===============================================================================================
 */
package com.tw.apistackbase.entity;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private int salary;

    Employee(){
        
    }
    
    public Employee(int id, String name, String gender, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
