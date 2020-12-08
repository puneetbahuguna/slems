package com.sl.ems.services;

import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class DeleteEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LoginService loginService;

    public boolean deleteEmployee(BigInteger id){
        try {
            employeeRepository.deleteEmployee(id);
            loginService.deleteUser(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
