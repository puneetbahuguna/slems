package com.sl.ems.controllers.admin;

import com.sl.ems.models.Employees;
import com.sl.ems.services.EmployeeService;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ViewEmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SessionComponent sessionComponent;

    @RequestMapping("viewemployee")
    public String addViewEmpPage(HttpSession session, Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            //List<Employees> empL=employeeService.getEmployeeList();
            model.addAttribute("emplist",employeeService.getEmployeeList());
            return "viewemployee";
        }else return "redirect:relogin";
    }
}
