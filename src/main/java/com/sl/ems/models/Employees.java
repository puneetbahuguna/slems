package com.sl.ems.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Employees {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This Entity class mapped to the employees table in the database.
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger EMPID;
    private String FIRSTNAME;
    private String LASTNAME;
    private Date DOB;
    private String EMAIL;
    @Transient
    private BigInteger DEPARTMENT_ID;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Employees(){
    }
    public Employees(BigInteger EMPID){
        this.EMPID=EMPID;
    }
    public Employees(String FIRSTNAME,String LASTNAME,Date DOB,String EMAIL,Department department){
        this.FIRSTNAME=FIRSTNAME;
        this.LASTNAME=LASTNAME;
        this.DOB=DOB;
        this.EMAIL=EMAIL;
        this.department=department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setDEPARTMENT_ID(BigInteger DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public BigInteger getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }
}
