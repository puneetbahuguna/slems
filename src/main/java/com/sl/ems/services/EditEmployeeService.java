package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.models.Login_Master;
import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LoginService loginService;

    public boolean editEmployee(Employees empData, Login_Master login_master){
        try {
            employeeRepository.editEmployeeDetails(empData.getFIRSTNAME(), empData.getLASTNAME(), empData.getDOB(),
                    empData.getEMAIL(), empData.getDEPARTMENT_ID(), empData.getEMPID());
            loginService.editLoginMaster(login_master);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
