package com.sl.ems.controllers.employee;

import com.sl.ems.models.Compliance;
import com.sl.ems.services.RegulationService;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TrackDepartmentCompliance {

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles the track department compliance by user functionality.
     **/

    @Autowired
    private RegulationService regulationService;
    @Autowired
    private SessionComponent sessionComponent;

    /** Following method loads the all department compliance with status page.**/
    @RequestMapping("trackdeptregulations")
    public String trackDeptRegulations(Model model){
        if(sessionComponent.isEmpSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("reglist",regulationService.
                    getAllDeptRegulation(sessionComponent.getSessionUserDeptId()));
            return "trackdeptregulation";
        }else return "redirect:relogin";
    }
}
