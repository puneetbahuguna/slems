package com.sl.ems.controllers.admin;

import com.sl.ems.services.DepartmentService;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ViewDepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SessionComponent sessionComponent;

    @RequestMapping("viewdepartment")
    public String addViewDeptPage(HttpSession session, Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "viewdepartment";
        }else return "redirect:relogin";
    }
}
