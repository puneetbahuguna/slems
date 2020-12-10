package com.sl.ems.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="statusreport")
public class StatusReport {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This Entity class mapped to the statusreport table in the database.
     **/
    private BigInteger COMPLIANCEID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger STATUSRPTID;
    private BigInteger EMPID;
    private String COMMENTS;
    private Date CREATEDDATE;
    private BigInteger DEPARTMENT_ID;

   /* @OneToOne
    @JoinTable(name = "Employees")
    @JoinColumn(name = "EMPID")
    private Employees employee;*/


    public StatusReport(){
    }
    public StatusReport(String COMMENTS,Date CREATEDDATE){

    }
    public StatusReport(BigInteger COMPLIANCEID,BigInteger EMPID,
                        String COMMENTS,Date CREATEDDATE,BigInteger DEPARTMENT_ID){
        this.COMPLIANCEID=COMPLIANCEID;
        this.EMPID=EMPID;
        this.COMMENTS=COMMENTS;
        this.CREATEDDATE=CREATEDDATE;
        this.DEPARTMENT_ID=DEPARTMENT_ID;
    }
    public BigInteger getCOMPLIANCEID() {
        return COMPLIANCEID;
    }

    public void setCOMPLIANCEID(BigInteger COMPLIANCEID) {
        this.COMPLIANCEID = COMPLIANCEID;
    }

    public BigInteger getSTATUSRPTID() {
        return STATUSRPTID;
    }

    public void setSTATUSRPTID(BigInteger STATUSRPTID) {
        this.STATUSRPTID = STATUSRPTID;
    }

    public BigInteger getEMPID() {
        return EMPID;
    }

    public void setEMPID(BigInteger EMPID) {
        this.EMPID = EMPID;
    }

    public String getCOMMENTS() {
        return COMMENTS;
    }

    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS;
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

    /*public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }*/
}
