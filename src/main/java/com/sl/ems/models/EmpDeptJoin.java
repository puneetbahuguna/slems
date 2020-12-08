package com.sl.ems.models;

import java.math.BigInteger;
import java.util.Date;

public class EmpDeptJoin {
    private BigInteger EMPID;
    private String FIRSTNAME;
    private String LASTNAME;
    private Date DOB;
    private String EMAIL;
    private BigInteger DEPARTMENT_ID;
    private String DEPARTMENT_NM;

    public EmpDeptJoin(){

    }
    public BigInteger getEMPID() {
        return EMPID;
    }

    public void setEMPID(BigInteger EMPID) {
        this.EMPID = EMPID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public BigInteger getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(BigInteger DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getDEPARTMENT_NM() {
        return DEPARTMENT_NM;
    }

    public void setDEPARTMENT_NM(String DEPARTMENT_NM) {
        this.DEPARTMENT_NM = DEPARTMENT_NM;
    }
}
