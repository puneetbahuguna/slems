package com.sl.ems.controllers.admin;

import com.sl.ems.models.Department;
import com.sl.ems.models.Employees;
import com.sl.ems.models.Login_Master;
import com.sl.ems.services.*;
import com.sl.ems.utils.SessionComponent;
import com.sl.ems.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class ViewEmployeeController {

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles the View Employee functionality.
     **/

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private DeleteEmployeeService deleteEmployeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private EditEmployeeService editEmployeeService;

    /** This method loads the View employee page.**/
    @RequestMapping("viewemployee")
    private String addViewEmpPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("emplist",employeeService.getEmployeeList());
            return "viewemployee";
        }else return "redirect:relogin";
    }

    /** Following method delete the employee by admin.**/
    @RequestMapping("deleteEmployee")
    public String deleteEmployee(Model model, @RequestParam("empId") String empId) {
        if (sessionComponent.isAdminSession() && deleteEmployeeService.deleteEmployee(new BigInteger(empId))) {
            return addViewEmpPage(model);
        } else return "redirect:relogin";
    }

    /** Following method load the edit employee page.**/
    @RequestMapping("editEmployee")
    private String addEditEmpPage(Model model,@RequestParam("empId") String empId){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            Employees emp= employeeService.getEmpById(new BigInteger(empId));
            model.addAttribute("userpwd",Utils.getBase64Decoding(loginService.findEmpPWDById(new BigInteger(empId))));
            model.addAttribute("dob",Utils.getFormattedDateString(emp.getDOB()));
            model.addAttribute("employee",emp);
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "editemployee";
        }else return "redirect:relogin";
    }

    /** Following method updates the employee information from edit employee page.**/
    @RequestMapping(value = "editempform",method = RequestMethod.POST)
    public String editEmployeeForm(Model model,@RequestParam("firstname") String firstname,
                                   @RequestParam("lastname") String lastname,@RequestParam("dob") String dob,
                                   @RequestParam("email") String email, @RequestParam("deptid") String deptid,
                                   @RequestParam("setpassword") String setpassword,@RequestParam("empid") String empid){
        Login_Master login_master = new Login_Master(new BigInteger(empid),setpassword);
        Employees employeesData = new Employees(firstname,lastname, Utils.getFormattedDate(dob),email,
                new Department(new BigInteger(deptid)));
        employeesData.setDEPARTMENT_ID(employeesData.getDepartment().getDEPARTMENT_ID());
        employeesData.setEMPID(new BigInteger(empid));
        login_master.setPassword(Utils.getBase64Encoding(setpassword));
        if(sessionComponent.isAdminSession() && editEmployeeService.editEmployee(employeesData,login_master)){
                return addViewEmpPage(model);
        }else return addEditEmpPage(model,empid);
    }
}
