package com.sl.ems.services;

import com.sl.ems.models.Employees;
import com.sl.ems.models.LoginUser;
import com.sl.ems.models.Login_Master;
import com.sl.ems.repositories.EmployeeRepository;
import com.sl.ems.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LoginService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles login functionality.
     **/

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    /**This method checks for users credentials if successful authentication returns the user information.**/
    public LoginUser getLoggedInUser(Login_Master userData){
        LoginUser userObj;
        Login_Master data = loginRepository.findUserByIdPassword(userData.getUSERID(),
                userData.getPassword());
        if(data!=null){
           Employees emp = employeeRepository.findEmployeeDetails(data.getUSERID());
           userObj=new LoginUser(data.getUSERID(),data.getROLE(),emp.getFIRSTNAME(),
                   emp.getLASTNAME(),emp.getDepartment().getDEPARTMENT_ID(),emp.getDepartment().getDEPARTMENT_NM());

        }else{
            userObj=new LoginUser();
            userObj.setValidCredentials(false);
        }
        return userObj;
    }

    /**This method fetch employee password for edit employee page.**/
    public String findEmpPWDById(BigInteger userId){
        return loginRepository.findEmpPWDById(userId);
    }

    /**This method edit the password in the login_master table if admin updates it from edit employee page**/
    void editLoginMaster(Login_Master login_master){
       loginRepository.editLoginMaster(login_master.getPassword(),login_master.getUSERID());
    }

    /**Delete the user from the login_master table**/
    void deleteUser(BigInteger userId){
       loginRepository.deleteUser(userId);
    }

}
