package com.sl.ems.controllers.employee;

import com.sl.ems.models.StatusReport;
import com.sl.ems.services.RegulationService;
import com.sl.ems.services.StatusReportService;
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
public class UpdateUserRegulation {

    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private RegulationService regulationService;
    @Autowired
    private StatusReportService statusReportService;

    @RequestMapping("adduserregulation")
    public String addUserRegulation(Model model,@RequestParam("regulationId") String complianceId){
        if(sessionComponent.isEmpSession()){
            model.addAttribute("regulation",regulationService.getRegulationById(new BigInteger(complianceId)));
            model.addAttribute("commentMsg", statusReportService.
                    getUserCommentonCompliance(new BigInteger(complianceId),sessionComponent.getSessionUserId()));
            sessionComponent.getSessionModel(model);
            return "adduserregulationcomment";
        }else return "redirect:relogin";
    }

    /** This method saves the department into database.**/
    @RequestMapping(value = "updateusercomment",method = RequestMethod.POST)
    public String updateUserComment(@RequestParam("usercomment") String userComment,
                                 @RequestParam("actionFlag") String actionFlag,
                                 @RequestParam("complianceId") String complianceId, Model model){
        if(sessionComponent.isEmpSession() && statusReportService.addOrUpdateUserComment
                (new StatusReport(new BigInteger(complianceId),sessionComponent.getSessionUserId(),
                        userComment, Utils.getCurrentDate(),sessionComponent.getSessionUserDeptId()),getActionFlag(actionFlag))){
        }
        return addUserRegulation(model,complianceId);
    }

    private boolean getActionFlag(String actionString){
        return actionString.equals(UtilConstants.NO_COMMENT_MSG);
    }
}
