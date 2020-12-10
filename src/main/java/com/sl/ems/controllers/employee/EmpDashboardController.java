package com.sl.ems.controllers.employee;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EmpDashboardController {

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles loading of employee dashboard.
     **/

    @Autowired
    private SessionComponent sessionComponent;

    /** Following method loads the employee dashboard page.**/
    @RequestMapping("employee")
        public String getEmpDashboard(HttpSession session, Model model){
            if(sessionComponent.isEmpSession()){
                sessionComponent.getSessionModel(model);
                return "employee";
            }else return "redirect:relogin";
    }
}
