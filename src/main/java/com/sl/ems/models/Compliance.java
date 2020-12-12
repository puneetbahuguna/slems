package com.sl.ems.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Compliance {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This Entity class mapped to the compliance table in the database.
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger COMPLIANCEID;
    private String RLTYPE;
    private String DETAILS;
    private Date CREATEDDATE;
    private String STATUS;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Compliance(){
    }
    public Compliance(String RLTYPE,String DETAILS,Date CREATEDDATE,String STATUS,Department department){
        this.RLTYPE=RLTYPE;
        this.DETAILS=DETAILS;
        this.CREATEDDATE=CREATEDDATE;
        this.STATUS=STATUS;
        this.department=department;
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

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
