package com.sl.ems.models;

import java.math.BigInteger;
import java.util.Date;

public class ComplianceDeptJoin {
    private BigInteger COMPLIANCEID;
    private String RLTYPE;
    private String DETAILS;
    private Date CREATEDDATE;
    private BigInteger DEPARTMENT_ID;
    private String STATUS;
    private String DEPARTMENT_NM;

    public ComplianceDeptJoin(){

    }
    public BigInteger getCOMPLIANCEID() {
        return COMPLIANCEID;
    }

    public void setCOMPLIANCEID(BigInteger COMPLIANCEID) {
        this.COMPLIANCEID = COMPLIANCEID;
    }

    public String getRLTYPE() {
        return RLTYPE;
    }

    public void setRLTYPE(String RLTYPE) {
        this.RLTYPE = RLTYPE;
    }

    public String getDETAILS() {
        return DETAILS;
    }

    public void setDETAILS(String DETAILS) {
        this.DETAILS = DETAILS;
    }

    public Date getCREATEDDATE() {
        return CREATEDDATE;
    }

    public void setCREATEDDATE(Date CREATEDDATE) {
        this.CREATEDDATE = CREATEDDATE;
    }

    public BigInteger getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(BigInteger DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getDEPARTMENT_NM() {
        return DEPARTMENT_NM;
    }

    public void setDEPARTMENT_NM(String DEPARTMENT_NM) {
        this.DEPARTMENT_NM = DEPARTMENT_NM;
    }
}
