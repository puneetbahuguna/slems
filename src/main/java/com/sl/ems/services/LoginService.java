package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.models.LoginUser;
import com.sl.ems.models.Login_Master;
import com.sl.ems.repositories.EmployeeRepository;
import com.sl.ems.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public LoginUser getLoggedInUser(Login_Master userData){
        LoginUser userObj;
        Login_Master data = loginRepository.findUserByIdPassword(userData.getUSERID(),
                userData.getPassword());
        if(data!=null){
           Employees emp = employeeRepository.findEmployeeDetails(data.getUSERID());
           userObj=new LoginUser(data.getUSERID(),data.getROLE(),emp.getFIRSTNAME(),
                   emp.getLASTNAME(),emp.getDEPARTMENT_ID());
        }else{
            userObj=new LoginUser();
            userObj.setValidCredentials(false);
        }
        return userObj;
    }
}
