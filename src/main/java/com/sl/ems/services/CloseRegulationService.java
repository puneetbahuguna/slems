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
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles closed regulation functionality.
     **/
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StatusReportRepo statusReportRepo;
    @Autowired
    private RegulationRepo regulationRepo;

    /** This method closed the regulation from open in compliance table. either all employee submitted
     * their comments or admin have closed it**/
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
