package com.sl.ems.services;

import com.sl.ems.models.Compliance;
import com.sl.ems.repositories.RegulationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RegulationService {
    @Autowired
    RegulationRepo regulationRepo;

    public boolean addRegulation(Compliance regulationObj){
        try {
            regulationRepo.save(regulationObj);
            return true;
        }catch (Exception e){
        }
        return false;
    }
    public List<Compliance> getAllRegulations(){
        return regulationRepo.findAll();
    }
    public List<Compliance> getAllDeptRegulation(BigInteger deptId){
        return regulationRepo.getAllDeptRegulation(deptId);
    }

    public List<Compliance> getAllUserRegulations(BigInteger deptID,String status){
        return regulationRepo.getAllUserRegulations(deptID,status);
    }
    public Compliance getRegulationById(BigInteger complianceId){
        return regulationRepo.getRegulationById(complianceId);
    }
}
