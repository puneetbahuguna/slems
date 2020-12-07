package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employees> getEmployeeList(){
        return employeeRepository.findAll();
    }

}
