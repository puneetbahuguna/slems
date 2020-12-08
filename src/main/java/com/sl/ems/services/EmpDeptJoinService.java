package com.sl.ems.services;

import com.sl.ems.models.EmpDeptJoin;

import java.util.List;

public interface EmpDeptJoinService {
    List<EmpDeptJoin> getEmployeeWithDeptNameList();
}
