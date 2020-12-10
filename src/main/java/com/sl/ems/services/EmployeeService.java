package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EmployeeService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles fetching employee records functionality.
     **/

    @Autowired
    private EmployeeRepository employeeRepository;

    /**This method fetches the records of all the employees in the database**/
    public List<Employees> getEmployeeList(){
        return employeeRepository.getEmployeeList();
    }

    /**This method fetches the record of a single employee by the employee id**/
    public Employees getEmpById(BigInteger empId){
        return employeeRepository.findEmployeeDetails(empId);
    }
}
