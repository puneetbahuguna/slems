package com.sl.ems.controllers.admin;

import com.sl.ems.services.RegulationService;
import com.sl.ems.utils.SessionComponent;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Controller
public class ViewRegulationController {

    @Autowired
    private RegulationService regulationService;
    @Autowired
    private SessionComponent sessionComponent;

    @RequestMapping("viewregulation")
    public String addViewRegPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            //List<Employees> empL=employeeService.getEmployeeList();
            model.addAttribute("reglist",regulationService.getAllRegulations());
            return "viewregulation";
        }else return "redirect:relogin";
    }

    @RequestMapping("viewuserregulation")
    public String addViewUserRegPage(HttpSession session, Model model){
        if(sessionComponent.isEmpSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("reglist",regulationService.getAllUserRegulations
                    (new BigInteger(session.getAttribute("deptid").toString()), UtilConstants.DEFAULT_REGULATION_STATUS));
            return "viewuserregulation";
        }else return "redirect:relogin";
    }

}
