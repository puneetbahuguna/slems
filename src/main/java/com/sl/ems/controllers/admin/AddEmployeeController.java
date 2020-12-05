package com.sl.ems.controllers.admin;

import com.sl.ems.models.Employees;
import com.sl.ems.models.Login_Master;
import com.sl.ems.services.AddEmployeeService;
import com.sl.ems.services.DepartmentService;
import com.sl.ems.utils.SessionComponent;
import com.sl.ems.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;

/**
 @Author: Puneet Kumar Bahuguna
 @Year: DEC 2020
 @Project: SimplyLearn EMS
 @Description: This controller class handles the functionality of adding a department by admin.
 **/
@Controller
public class AddEmployeeController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AddEmployeeService addEmployeeService;

    @Autowired
    private SessionComponent sessionComponent;

    @RequestMapping("addemp")
    public String addEmpPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "addemployee";
        }else return "redirect:relogin";
    }
    @RequestMapping(value = "addempform",method = RequestMethod.POST)
    public String addEmployee(@RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,@RequestParam("dob") String dob,
                              @RequestParam("email") String email, @RequestParam("deptid") String deptid,
                              @RequestParam("setpassword") String setpassword,Model model){
        Login_Master login_master = new Login_Master();
        Employees employeesData = new Employees(firstname,lastname, Utils.getFormattedDate(dob),email,new BigInteger(deptid));
        login_master.setPassword(Utils.getBase64Encoding(setpassword));
        login_master.setROLE("employee");
        if(sessionComponent.isAdminSession() && addEmployeeService.addEmployee(login_master,employeesData)){
            model.addAttribute("msg","Employee is added Successfully!");
        }else model.addAttribute("msg","Some Error Occurred!");
        return addEmpPage(model);
    }
}
