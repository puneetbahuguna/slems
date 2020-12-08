package com.sl.ems.services;

import com.sl.ems.models.ComplianceDeptJoin;

import java.math.BigInteger;
import java.util.List;

public interface CompDeptJoinService {

    List<ComplianceDeptJoin> getRegulationsListWithDept();

}
