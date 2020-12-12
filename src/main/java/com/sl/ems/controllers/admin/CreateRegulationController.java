package com.sl.ems.controllers.admin;

import com.sl.ems.models.Compliance;
import com.sl.ems.models.Department;
import com.sl.ems.services.RegulationService;
import com.sl.ems.services.DepartmentService;
import com.sl.ems.utils.SessionComponent;
import com.sl.ems.utils.UtilConstants;
import com.sl.ems.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class CreateRegulationController {

 /**
   Author: Puneet Kumar Bahuguna
   Year: DEC 2020
   Project: SimplyLearn EMS
   Description: This controller class handles the functionality of adding  a regulation by admin.
 **/

    @Autowired
    private RegulationService addRegulationService;

    @Autowired
    private SessionComponent sessionComponent;

    @Autowired
    private DepartmentService departmentService;

    /** Following method loads the create regulation page.**/
    @RequestMapping("addregulation")
    private String addRegulationPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            //List<Department> dept =  departmentService.getDepartmentList();
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "createregulation";
        }else return "redirect:relogin";
    }

    /** Following method create the regulation by admin in the database**/
    @RequestMapping(value = "createregulation",method = RequestMethod.POST)
    public String addRegulation(@RequestParam("rltype") String rltype, @RequestParam("rldetails") String rldetails,
                              @RequestParam("deptid") String deptid,@RequestParam("cdate") String cdate,Model model){
        if(sessionComponent.isAdminSession() && addRegulationService.addRegulation(new Compliance
                (rltype,rldetails, Utils.getFormattedDate(cdate), UtilConstants.DEFAULT_REGULATION_STATUS,
                        new Department(new BigInteger(deptid))))){
            model.addAttribute("msg","Regulation is added Successfully!");
        } else model.addAttribute("msg","Some Error Occurred!");
        return addRegulationPage(model);
    }
}
