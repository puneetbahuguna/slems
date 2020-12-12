package com.sl.ems.controllers.employee;

import com.sl.ems.models.Employees;
import com.sl.ems.models.StatusReport;
import com.sl.ems.services.CloseRegulationService;
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

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles the Update User regulations functionality.
     **/

    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private RegulationService regulationService;
    @Autowired
    private StatusReportService statusReportService;
    @Autowired
    private CloseRegulationService closeRegulationService;

    /** Following method loads the regulation details page along with user's own comment.**/
    @RequestMapping("adduserregulation")
    private String addUserRegulation(Model model,@RequestParam("regulationId") String complianceId){
        if(sessionComponent.isEmpSession()){
            model.addAttribute("regulation",regulationService.getRegulationById(new BigInteger(complianceId)));
            StatusReport ss = statusReportService.getUserCommentonCompliance
                    (new BigInteger(complianceId),sessionComponent.getSessionUserId());
            if(ss!=null){
                model.addAttribute("commentMsg", ss.getCOMMENTS());
                model.addAttribute("comdate"," - On "+ss.getCREATEDDATE());
            }else {
                model.addAttribute("commentMsg", UtilConstants.NO_COMMENT_MSG);
            }
            sessionComponent.getSessionModel(model);
            return "adduserregulationcomment";
        }else return "redirect:relogin";
    }

    /** This method updates the user comment in the database until and unless the
     * regulation is not closed.
     * This method also checks if the comment added/updated by the user is the last
     * employee in the dept who is updating, if true this method also close the regulation.
     * **/
    @RequestMapping(value = "updateusercomment",method = RequestMethod.POST)
    public String updateUserComment(@RequestParam("usercomment") String userComment,
                                 @RequestParam("actionFlag") String actionFlag,
                                 @RequestParam("complianceId") String complianceId, Model model){
        StatusReport statusData = new StatusReport(new BigInteger(complianceId),userComment, Utils.getCurrentDate(),
                sessionComponent.getSessionUserDeptId(),new Employees(sessionComponent.getSessionUserId()));
        if(sessionComponent.isEmpSession() && statusReportService.addOrUpdateUserComment(statusData,getActionFlag(actionFlag))){
            closeRegulationService.closeRegulation(sessionComponent.getSessionUserDeptId(),
                    new BigInteger(complianceId));
        }
        return addUserRegulation(model,complianceId);
    }

    /** Following method checks if user is adding comment for the first time or
     * updating the comment based on the action insert and update commands fires.**/
    private boolean getActionFlag(String actionString){
        return actionString.equals(UtilConstants.NO_COMMENT_MSG);
    }
}
