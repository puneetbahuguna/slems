package com.sl.ems.controllers.admin;

import com.sl.ems.models.Department;
import com.sl.ems.services.DepartmentService;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
Author: Puneet Kumar Bahuguna
Year: DEC 2020
Project: SimplyLearn EMS
Description: This controller class handles the functionality of adding a department by admin.
 **/

@Controller
public class AddDepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SessionComponent sessionComponent;

    /** This method loads the initial add department page.**/
    @RequestMapping("adddept")
    private String addDeptPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            return "adddepartment";
        }else return "redirect:relogin";
    }

    /** This method saves the department into database.**/
    @RequestMapping(value = "adddeptform",method = RequestMethod.POST)
    public String addDeptForm(@RequestParam("deptname") String deptname,Model model){
        if(sessionComponent.isAdminSession() && departmentService.addDepartment(new Department(deptname))){
            model.addAttribute("msg","Department is added Successfully!");
        }else model.addAttribute("msg","Some Error Occurred!");
        return addDeptPage(model);
    }
}
