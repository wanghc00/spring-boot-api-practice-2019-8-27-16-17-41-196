/*
 * Copyright (C), 1992-2019
 * Package com.tw.apistackbase.controller 
 * FileName: CompanyResource.java
 * Author:   wang-hc
 * Date:     2019年8月28日 下午5:56:17
 * Description: //模块目的、功能描述      
 * History: //修改记录
 *===============================================================================================
 *   author：          time：                             version：           desc：
 *   wang-hc           2019年8月28日下午5:56:17                     1.0                  
 *===============================================================================================
 */
package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
    
    private List<Company> companies = new ArrayList<Company>();
    
        public CompanyResource(){
            Company campany001 = new Company("company001", "001");
            campany001.addEmployee(new Employee(1, "张三", "男", 6000));
            campany001.addEmployee(new Employee(2, "李四", "男", 6100));
            campany001.addEmployee(new Employee(3, "王五", "男", 6200));
            Company campany002 = new Company("company002", "002");
            campany002.addEmployee(new Employee(1, "赵六", "男", 6300));
            Company campany003 = new Company("company003", "003");
            companies.add(campany001);
            companies.add(campany002);
            companies.add(campany003);
            companies.add(new Company("company004", "004"));
            companies.add(new Company("company005", "005"));
            companies.add(new Company("company006", "006"));
    }
    
    @GetMapping("")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companies);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id) {
        for (Company company : companies) {
            if (company.getId().equals(id)) {
                return ResponseEntity.ok(company);
            }
        }
        return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByCampanyId(@PathVariable String id){
        for (Company company : companies) {
            if (company.getId().equals(id)) {
                return ResponseEntity.ok(company.getEmployees());                
            }
        }
        return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Company> getCompaniesbyPage (@RequestParam int page, @RequestParam int pageSize){
        List<Company> companyList = new ArrayList<Company>();
        for (int i = 0; i < page; i++) {
            for (int j = 0; j < pageSize; j++) {
                companyList.add(companies.get(i*pageSize+j));
            }
        }
        return companyList;
        
    }
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        companies.add(company);
        return company;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<List<Company>> updateCompanyById(@PathVariable String id, @RequestBody Company paramCompany){
        for (Company company : companies) {
            if (company.getId().equals(id)) {
                company.setName(paramCompany.getName());
                company.setEmployees(paramCompany.getEmployees());
            }
        }
        return ResponseEntity.ok(companies);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Company>> deleteCompanyById(@PathVariable String id){
        for (Company company : companies) {
            if (company.getId().equals(id)) {
                companies.remove(company);
                return ResponseEntity.ok(companies);
            }
        }
        return new ResponseEntity<List<Company>>(HttpStatus.NOT_FOUND);
    }
}
