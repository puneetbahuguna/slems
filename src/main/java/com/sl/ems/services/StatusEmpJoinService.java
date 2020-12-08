package com.sl.ems.services;

import com.sl.ems.models.StatusEmpJoin;

import java.math.BigInteger;
import java.util.List;

public interface StatusEmpJoinService {

    List<StatusEmpJoin> getAllUserComments(BigInteger complianceId);
}
