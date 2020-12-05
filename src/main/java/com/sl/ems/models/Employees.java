package com.sl.ems.models;

import com.sl.ems.utils.Utils;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger EMPID;
    private String FIRSTNAME;
    private String LASTNAME;
    private Date DOB;
    private String EMAIL;
    private BigInteger DEPARTMENT_ID;

    public Employees(){
    }
    public Employees(String FIRSTNAME,String LASTNAME,Date DOB,String EMAIL,BigInteger DEPARTMENT_ID){
        this.FIRSTNAME=FIRSTNAME;
        this.LASTNAME=LASTNAME;
        this.DOB=DOB;
        this.EMAIL=EMAIL;
        this.DEPARTMENT_ID=DEPARTMENT_ID;
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
        return Utils.getDOBFormattedDate(DOB);
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
}
