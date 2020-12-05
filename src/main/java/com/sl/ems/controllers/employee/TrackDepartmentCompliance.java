package com.sl.ems.controllers.employee;

import com.sl.ems.services.RegulationService;
import com.sl.ems.utils.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackDepartmentCompliance {

    @Autowired
    private RegulationService regulationService;
    @Autowired
    private SessionComponent sessionComponent;

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
