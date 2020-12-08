package com.sl.ems.services;

import com.sl.ems.models.Compliance;
import com.sl.ems.models.ComplianceDeptJoin;
import com.sl.ems.repositories.RegulationRepo;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Service
public class RegulationService implements CompDeptJoinService {
    @Autowired
    private RegulationRepo regulationRepo;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public boolean addRegulation(Compliance regulationObj){
        try {
            regulationRepo.save(regulationObj);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /*public List<Compliance> getAllRegulations(){
        return regulationRepo.getAllAdminRegulations();
    }*/
    public List<Compliance> getAllDeptRegulation(BigInteger deptId){
        return regulationRepo.getAllDeptRegulation(deptId);
    }

    public boolean updateComplianceStatus(BigInteger complianceId){
        try{
            regulationRepo.updateComplianceStatus(UtilConstants.CLOSED_REGULATION_STATUS,complianceId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Compliance> getAllUserRegulations(BigInteger deptID,String status){
        return regulationRepo.getAllUserRegulations(deptID,status);
    }

    public Compliance getRegulationById(BigInteger complianceId){
        return regulationRepo.getRegulationById(complianceId);
    }

    @Override
    public List<ComplianceDeptJoin> getRegulationsListWithDept() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("select c.COMPLIANCEID,c.RLTYPE,c.DETAILS,c.CREATEDDATE,c.STATUS,c.DEPARTMENT_ID," +
                "d.DEPARTMENT_NM from Compliance c inner join Department d on c.DEPARTMENT_ID=d.DEPARTMENT_ID order by c.COMPLIANCEID desc");
        @SuppressWarnings("unchecked")
        List<ComplianceDeptJoin> regList = (List<ComplianceDeptJoin>)query.getResultList();
        em.close();
        return regList;
    }
}
