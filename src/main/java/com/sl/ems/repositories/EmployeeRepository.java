package com.sl.ems.repositories;

import com.sl.ems.models.Employees;
import com.sl.ems.models.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, BigInteger> {

    @Query(value = "select * from employees WHERE EMPID=?1",nativeQuery = true)
    Employees findEmployeeDetails(BigInteger empId);

   /* @Query(value = "select EMPID,FIRSTNAME,LASTNAME,DOB,EMAIL,department.DEPARTMENT_ID,department.DEPARTMENT_NM from employees inner join department where employees.DEPARTMENT_ID=department.DEPARTMENT_ID;",nativeQuery = true)
    List<Employees> getEmpList();*/

}
