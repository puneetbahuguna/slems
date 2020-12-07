package com.sl.ems.controllers.admin;

import com.sl.ems.models.Compliance;
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

    @Autowired
    private RegulationService addRegulationService;

    @Autowired
    private SessionComponent sessionComponent;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("addregulation")
    public String addRegulationPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            //List<Department> dept =  departmentService.getDepartmentList();
            model.addAttribute("deptlist",departmentService.getDepartmentList());
            return "createregulation";
        }else return "redirect:relogin";
    }
    @RequestMapping(value = "createregulation",method = RequestMethod.POST)
    public String addRegulation(@RequestParam("rltype") String rltype, @RequestParam("rldetails") String rldetails,
                              @RequestParam("deptid") String deptid,@RequestParam("cdate") String cdate,Model model){
        if(sessionComponent.isAdminSession() && addRegulationService.addRegulation(new Compliance
                (rltype,rldetails, Utils.getFormattedDate(cdate),new BigInteger(deptid), UtilConstants.DEFAULT_REGULATION_STATUS))){
            model.addAttribute("msg","Regulation is added Successfully!");
        } else model.addAttribute("msg","Some Error Occurred!");
        return addRegulationPage(model);
    }
}
