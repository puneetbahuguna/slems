package com.sl.ems.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity(name = "login_master")
public class Login_Master {
    @Id
    private BigInteger USERID;
    private String PASSWORD;
    private String ROLE;

    public Login_Master(){

    }
    public Login_Master(BigInteger USERID,String PASSWORD){
        this.USERID=USERID;
        this.PASSWORD=PASSWORD;
    }
    public BigInteger getUSERID() {
        return USERID;
    }

    public void setUSERID(BigInteger USERID) {
        this.USERID = USERID;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getROLE() {
        return ROLE;
    }
    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }
}
