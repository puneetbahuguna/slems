package com.sl.ems.controllers.employee;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EmpDashboardController {

    @Autowired
    private SessionComponent sessionComponent;

        @RequestMapping("employee")
        public String getEmpDashboard(HttpSession session, Model model){
            if(sessionComponent.isEmpSession()){
                sessionComponent.getSessionModel(model);
                return "employee";
            }else return "redirect:relogin";
    }
}
