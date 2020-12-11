package com.sl.ems.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Department {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This Entity class mapped to the department table in the database.
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger DEPARTMENT_ID;
    private String DEPARTMENT_NM;

    public Department(){
    }
    public Department(String DEPARTMENT_NM){
        this.DEPARTMENT_NM=DEPARTMENT_NM;
    }
    public Department(BigInteger DEPARTMENT_ID){
        this.DEPARTMENT_ID=DEPARTMENT_ID;
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
