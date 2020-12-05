package com.sl.ems.repositories;

import com.sl.ems.models.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface RegulationRepo extends JpaRepository<Compliance, BigInteger> {

    @Query(value = "select * from compliance WHERE DEPARTMENT_ID=?1 AND STATUS=?2 order by COMPLIANCEID DESC",nativeQuery = true)
    List<Compliance> getAllUserRegulations(BigInteger deptID,String status);

    @Query(value = "select * from compliance WHERE COMPLIANCEID=?1",nativeQuery = true)
    Compliance getRegulationById(BigInteger regulationId);

    @Query(value = "select * from compliance WHERE DEPARTMENT_ID=?1 order by COMPLIANCEID DESC",nativeQuery = true)
    List<Compliance> getAllDeptRegulation(BigInteger deptId);
}
