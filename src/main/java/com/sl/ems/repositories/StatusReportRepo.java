package com.sl.ems.repositories;

import com.sl.ems.models.StatusReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
/**
 Author: Puneet Kumar Bahuguna
 Year: DEC 2020
 Project: SimplyLearn EMS
 Description: This Repository interface handles loading of StatusReport data from the database.
 **/
public interface StatusReportRepo extends JpaRepository<StatusReport, BigInteger> {

    @Query(value = "select * from statusreport WHERE COMPLIANCEID=?1 AND EMPID=?2",nativeQuery = true)
    StatusReport getUserCommentonCompliance(BigInteger complianceId,BigInteger empId);

    @Query(value = "select * from statusreport WHERE COMPLIANCEID=?1",nativeQuery = true)
    List<StatusReport> getAllUserComments(BigInteger complianceId);

    @Transactional
    @Modifying
    @Query(value = "delete from statusreport where EMPID=?1",nativeQuery = true)
    void deleteEmployeeComments(BigInteger empId);

    @Transactional
    @Modifying
    @Query(value = "update statusreport set COMMENTS=?1 WHERE COMPLIANCEID=?2 AND EMPID=?3",nativeQuery = true)
    void updateUserComments(String comments,BigInteger complianceId,BigInteger empId);

    @Query(value = "select count(COMMENTS) from statusreport WHERE DEPARTMENT_ID=?1 AND COMPLIANCEID=?2",nativeQuery = true)
    int getEmpCountInDept(BigInteger deptId,BigInteger complianceId);
}
