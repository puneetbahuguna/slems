package com.sl.ems.services;

import com.sl.ems.repositories.EmployeeRepository;
import com.sl.ems.repositories.RegulationRepo;
import com.sl.ems.repositories.StatusReportRepo;
import com.sl.ems.utils.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CloseRegulationService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusReportRepo statusReportRepo;
    @Autowired
    private RegulationRepo regulationRepo;

    public boolean closeRegulation(BigInteger departmentId,BigInteger complianceId){
        try{
                int empCountInDept = employeeRepository.getEmpCountInDept(departmentId);
                int empCommentCount= statusReportRepo.getEmpCountInDept(departmentId,complianceId);
                if(empCountInDept==empCommentCount){
                    regulationRepo.updateComplianceStatus(UtilConstants.CLOSED_REGULATION_STATUS,complianceId);
                }
                return true;
        }catch (Exception e){
            return false;
        }
    }
}
