package com.sl.ems.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger DEPARTMENT_ID;
    private String DEPARTMENT_NM;

    public Department(){
    }
    public Department(String DEPARTMENT_NM){
        this.DEPARTMENT_NM=DEPARTMENT_NM;
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
