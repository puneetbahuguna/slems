package com.sl.ems.services;

import com.sl.ems.models.Compliance;
import com.sl.ems.repositories.RegulationRepo;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.math.BigInteger;
import java.util.List;

@Service
public class RegulationService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles the data of compliance.
     **/

    @Autowired
    private RegulationRepo regulationRepo;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    /**This method creates the new regulation in the compliance table in the database**/
    public boolean addRegulation(Compliance regulationObj){
        try {
            regulationRepo.save(regulationObj);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /**This method fetches the records of all regulation in the detabase which are visible to admin.**/
    public List<Compliance> getAllRegulations(){
        return regulationRepo.getAllAdminRegulations();
    }

    /**This method fetch the record of compliance for a department by department id, visible to user
     * in track department compliance page**/
    public List<Compliance> getAllDeptRegulation(BigInteger deptId){
        return regulationRepo.getAllDeptRegulation(deptId);
    }

    /**This method updates the regulation status in the database.**/
    public boolean updateComplianceStatus(BigInteger complianceId){
        try{
            regulationRepo.updateComplianceStatus(UtilConstants.CLOSED_REGULATION_STATUS,complianceId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**This method gets the list of all assigned regulation to a user, whose status is open**/
    public List<Compliance> getAllUserRegulations(BigInteger deptID,String status){
        return regulationRepo.getAllUserRegulations(deptID,status);
    }

    /**This method gets the details of a compliance on basis of compliance id.**/
    public Compliance getRegulationById(BigInteger complianceId){
        return regulationRepo.getRegulationById(complianceId);
    }
}
