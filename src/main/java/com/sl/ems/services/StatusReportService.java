package com.sl.ems.services;

import com.sl.ems.models.StatusReport;
import com.sl.ems.repositories.StatusReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class StatusReportService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles statusreport data.
     **/

    @Autowired
    private StatusReportRepo statusReportRepo;

    /**This method gets the comment of a user on a compliance, visible to user only.**/
    public StatusReport getUserCommentonCompliance(BigInteger complianceId,BigInteger empId){
       return statusReportRepo.getUserCommentonCompliance(complianceId,empId);
    }

    /**This method gets the list of all users comment on a compliance, visible to admin only.**/
    public List<StatusReport> getAllUserComments(BigInteger complianceId){
        return statusReportRepo.getAllUserComments(complianceId);
    }

    /**This method either add or update the user's comment in the database,
     * for the first time it add and after adding once it updates the comment for a particular user.**/
    public boolean addOrUpdateUserComment(StatusReport statusReport,boolean actionFlag){
        try {
            if (actionFlag) {
                statusReportRepo.save(statusReport);
                return true;
            } else {
                statusReportRepo.updateUserComments(statusReport.getCOMMENTS(), statusReport.getCOMPLIANCEID(),
                        statusReport.getEMPID());
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }
}