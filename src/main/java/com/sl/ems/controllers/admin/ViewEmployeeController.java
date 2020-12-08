package com.sl.ems.controllers.admin;

import com.sl.ems.models.EmpDeptJoin;
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
import java.util.List;

@Controller
public class ViewEmployeeController {

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

    @RequestMapping("viewemployee")
    public String addViewEmpPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            List<EmpDeptJoin> list = employeeService.getEmployeeWithDeptNameList();
            model.addAttribute("emplist",employeeService.getEmployeeWithDeptNameList());
            return "viewemployee";
        }else return "redirect:relogin";
    }

    @RequestMapping("deleteEmployee")
    public String deleteEmployee(Model model, @RequestParam("empId") String empId) {
        if (sessionComponent.isAdminSession() && deleteEmployeeService.deleteEmployee(new BigInteger(empId))) {
            return addViewEmpPage(model);
        } else return "redirect:relogin";
    }

    @RequestMapping("editEmployee")
    public String addEditEmpPage(Model model,@RequestParam("empId") String empId){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            Employees emp= employeeService.getEmpById(new BigInteger(empId));
            model.addAttribute("userpwd",Utils.getBase64Decoding(loginService.findEmpPWDById(new BigInteger(empId))));
            model.addAttribute("dob",Utils.getFormattedDateString(emp.getDOB()));
            model.addAttribute("employee",employeeService.getEmpById(new BigInteger(empId)));
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "editemployee";
        }else return "redirect:relogin";
    }

    @RequestMapping(value = "editempform",method = RequestMethod.POST)
    public String editEmployeeForm(Model model,@RequestParam("firstname") String firstname,
                                   @RequestParam("lastname") String lastname,@RequestParam("dob") String dob,
                                   @RequestParam("email") String email, @RequestParam("deptid") String deptid,
                                   @RequestParam("setpassword") String setpassword,@RequestParam("empid") String empid){
        Login_Master login_master = new Login_Master(new BigInteger(empid),setpassword);
        Employees employeesData = new Employees(firstname,lastname, Utils.getFormattedDate(dob),email,new BigInteger(deptid));
        employeesData.setEMPID(new BigInteger(empid));
        login_master.setPassword(Utils.getBase64Encoding(setpassword));
        if(sessionComponent.isAdminSession() && editEmployeeService.editEmployee(employeesData,login_master)){
                return addViewEmpPage(model);
        }else return addEditEmpPage(model,empid);
    }
}
