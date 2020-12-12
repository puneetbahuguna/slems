package com.sl.ems.controllers.admin;

import com.sl.ems.models.Compliance;
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

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Controller
public class ViewRegulationController {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles the View Regulations functionality.
     **/

    @Autowired
    private RegulationService regulationService;
    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private StatusReportService statusReportService;

    /** Following method loads the view regulation page.**/
    @RequestMapping("viewregulation")
    public String addViewRegPage(Model model){
        if(sessionComponent.isAdminSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("reglist",regulationService.getAllRegulations());
            return "viewregulation";
        }else return "redirect:relogin";
    }

    /** Following method loads the admin regulation details page.**/
    @RequestMapping("adminregulationdetails")
    private String addAdminRegDetails(Model model,@RequestParam("regulationId") String complianceId){
        if(sessionComponent.isAdminSession()){
            Compliance compliance = regulationService.getRegulationById(new BigInteger(complianceId));
            model.addAttribute("regulation",compliance);
            model.addAttribute("cdate", Utils.getFormattedDateString(compliance.getCREATEDDATE()));
            model.addAttribute("commentMsgs", statusReportService.
                    getAllUserComments(new BigInteger(complianceId)));
            if(compliance.getSTATUS().equals(UtilConstants.CLOSED_REGULATION_STATUS)) {
                model.addAttribute("successmsg","This Regulation is closed");
            }
            sessionComponent.getSessionModel(model);
            return "adminregulationdetails";
        }else return "redirect:relogin";
    }

    /** Following method updates the regulation status to closed by admin.**/
    @RequestMapping(value = "updateregstatus",method = RequestMethod.POST)
    public String updateUserComment(@RequestParam("complianceId") String complianceId, Model model){
        if(sessionComponent.isAdminSession()){
            regulationService.updateComplianceStatus(new BigInteger(complianceId));
        }
        return addAdminRegDetails(model,complianceId);
    }

    /** Following method loads the regulation assigned to the user page.**/
    @RequestMapping("viewuserregulation")
    public String addViewUserRegPage(HttpSession session, Model model){
        if(sessionComponent.isEmpSession()){
            sessionComponent.getSessionModel(model);
            model.addAttribute("reglist",regulationService.getAllUserRegulations
                    (new BigInteger(session.getAttribute("deptid").toString()),
                            UtilConstants.DEFAULT_REGULATION_STATUS));
            return "viewuserregulation";
        }else return "redirect:relogin";
    }
}
