package com.sl.ems.repositories;

import com.sl.ems.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

/**
 Author: Puneet Kumar Bahuguna
 Year: DEC 2020
 Project: SimplyLearn EMS
 Description: This Repository interface handles loading of department data from the database.
 **/
public interface DepartmentRepository extends JpaRepository<Department, BigInteger> {

}
