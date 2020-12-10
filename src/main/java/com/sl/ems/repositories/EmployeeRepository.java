package com.sl.ems.repositories;

import com.sl.ems.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 Author: Puneet Kumar Bahuguna
 Year: DEC 2020
 Project: SimplyLearn EMS
 Description: This Repository interface handles loading of employees data from the database.
 **/
public interface EmployeeRepository extends JpaRepository<Employees, BigInteger> {

    @Query(value = "select * from employees WHERE EMPID=?1",nativeQuery = true)
    Employees findEmployeeDetails(BigInteger empId);

    @Query(value = "select * from employees",nativeQuery = true)
    List<Employees> getEmployeeList();

   @Query(value = "select count(EMPID) from employees WHERE DEPARTMENT_ID=?1",nativeQuery = true)
   int getEmpCountInDept(BigInteger deptId);

   @Transactional
   @Modifying
   @Query(value = "update employees set FIRSTNAME=?1,LASTNAME=?2,DOB=?3,EMAIL=?4,DEPARTMENT_ID=?5 WHERE EMPID=?6"
           ,nativeQuery = true)
   void editEmployeeDetails(String firstName, String lastName, Date dob,String email,
                            BigInteger deptId,BigInteger empId);

   @Transactional
   @Modifying
   @Query(value = "delete from employees WHERE EMPID=?1",nativeQuery = true)
   void deleteEmployee(BigInteger empId);
}
