package com.sl.ems.services;

import com.sl.ems.models.StatusReport;
import com.sl.ems.repositories.StatusReportRepo;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class StatusReportService {

    @Autowired
    private StatusReportRepo statusReportRepo;

    public String getUserCommentonCompliance(BigInteger complianceId,BigInteger empId){
       StatusReport statusReport = statusReportRepo.getUserCommentonCompliance(complianceId,empId);
       if(statusReport!=null){
           return statusReport.getCOMMENTS();
       }
       return UtilConstants.NO_COMMENT_MSG;
    }

    public List<StatusReport> getAllUserComments(BigInteger complianceId){
        return statusReportRepo.getAllUserComments(complianceId);
    }

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
