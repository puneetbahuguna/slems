package com.sl.ems.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Compliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger COMPLIANCEID;
    private String RLTYPE;
    private String DETAILS;
    private Date CREATEDDATE;
    private BigInteger DEPARTMENT_ID;
    private String STATUS;
    public Compliance(){
    }
    public Compliance(String RLTYPE,String DETAILS,Date CREATEDDATE,BigInteger DEPARTMENT_ID,String STATUS){
        this.RLTYPE=RLTYPE;
        this.DETAILS=DETAILS;
        this.CREATEDDATE=CREATEDDATE;
        this.DEPARTMENT_ID=DEPARTMENT_ID;
        this.STATUS=STATUS;
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
}
