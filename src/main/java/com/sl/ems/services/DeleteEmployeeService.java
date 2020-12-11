package com.sl.ems.services;

import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class DeleteEmployeeService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles delete employee functionality.
     **/
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private StatusReportService statusReportService;

    /**This method deletes the employee record from both employees and login_master table. **/
    public boolean deleteEmployee(BigInteger id){
        try {
            statusReportService.deleteEmployeeComments(id);
            employeeRepository.deleteEmployee(id);
            loginService.deleteUser(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
