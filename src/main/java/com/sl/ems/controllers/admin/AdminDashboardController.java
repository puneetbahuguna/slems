package com.sl.ems.controllers.admin;

import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles loading of admin dashboard.
     **/

    @Autowired
    private SessionComponent sessionComponent;

    /** Following method loads the admin dashboard page.**/
    @RequestMapping("admin")
    public String getAdminDashboard(HttpSession session, Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            return "admin";
        }else return "redirect:relogin";
    }
}
