package com.sl.ems.services;

import com.sl.ems.models.StatusEmpJoin;
import com.sl.ems.models.StatusReport;
import com.sl.ems.repositories.StatusReportRepo;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Service
public class StatusReportService implements StatusEmpJoinService {

    @Autowired
    private StatusReportRepo statusReportRepo;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    public String getUserCommentonCompliance(BigInteger complianceId,BigInteger empId){
       StatusReport statusReport = statusReportRepo.getUserCommentonCompliance(complianceId,empId);
       if(statusReport!=null){
           return statusReport.getCOMMENTS();
       }
       return UtilConstants.NO_COMMENT_MSG;
    }

    @Override
    public List<StatusEmpJoin> getAllUserComments(BigInteger complianceId){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("select s.COMMENTS,s.CREATEDDATE," +
                "e.FIRSTNAME,e.LASTNAME from StatusReport s inner join Employees e on s.EMPID=e.EMPID WHERE s.COMPLIANCEID="+complianceId);
        @SuppressWarnings("unchecked")
        List<StatusEmpJoin> commentList = (List<StatusEmpJoin>)query.getResultList();
        em.close();
        return commentList;
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
