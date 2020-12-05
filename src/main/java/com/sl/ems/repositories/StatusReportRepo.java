package com.sl.ems.repositories;

import com.sl.ems.models.StatusReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface StatusReportRepo extends JpaRepository<StatusReport, BigInteger> {

    @Query(value = "select * from statusreport WHERE COMPLIANCEID=?1 AND EMPID=?2",nativeQuery = true)
    StatusReport getUserCommentonCompliance(BigInteger complianceId,BigInteger empId);

    @Query(value = "update statusreport set COMMENTS=?1 WHERE COMPLIANCEID=?2 AND EMPID=?3",nativeQuery = true)
    void updateUserComments(String comments,BigInteger complianceId,BigInteger empId);

}
