package com.sl.ems.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LoginUser {
    private BigInteger USERID;
    private String ROLE;
    private String FIRSTNAME;
    private String LASTNAME;
    private BigInteger DEPARTMENT_ID;
    private String DEPARTMENT_NM;
    private Boolean isValidCredentials=true;

    public LoginUser(){
    }
    public LoginUser(BigInteger USERID,String ROLE,String FIRSTNAME,String LASTNAME,
                     BigInteger DEPARTMENT_ID){
        this.USERID=USERID;
        this.ROLE=ROLE;
        this.FIRSTNAME=FIRSTNAME;
        this.LASTNAME=LASTNAME;
        this.DEPARTMENT_ID=DEPARTMENT_ID;
    }

    public BigInteger getUSERID() {
        return USERID;
    }

    public void setUSERID(BigInteger USERID) {
        this.USERID = USERID;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
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

    public Boolean getValidCredentials() {
        return isValidCredentials;
    }

    public void setValidCredentials(Boolean validCredentials) {
        isValidCredentials = validCredentials;
    }
}
