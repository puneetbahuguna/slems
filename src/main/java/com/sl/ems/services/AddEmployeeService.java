package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.models.Login_Master;
import com.sl.ems.repositories.EmployeeRepository;
import com.sl.ems.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LoginRepository loginRepository;

    public boolean addEmployee(Login_Master loginData, Employees empData){
        try {
            Employees insertedEmp = employeeRepository.save(empData);
            loginData.setUSERID(insertedEmp.getEMPID());
            loginRepository.save(loginData);
            return true;
        }catch (Exception e){
        }
        return false;
    }
}
