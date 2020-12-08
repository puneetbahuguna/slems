package com.sl.ems.services;

import com.sl.ems.models.EmpDeptJoin;
import com.sl.ems.models.Employees;
import com.sl.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Service
public class EmployeeService implements EmpDeptJoinService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EntityManagerFactory emf;

    public List<Employees> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public Employees getEmpById(BigInteger empId){
        return employeeRepository.findEmployeeDetails(empId);
    }

    @Override
    public List<EmpDeptJoin> getEmployeeWithDeptNameList() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select e.EMPID,e.FIRSTNAME,e.LASTNAME,e.DOB,e.EMAIL,e.DEPARTMENT_ID," +
                "d.DEPARTMENT_NM from Employees e inner join Department d on e.DEPARTMENT_ID=d.DEPARTMENT_ID");
        @SuppressWarnings("unchecked")
        List<EmpDeptJoin> empList = (List<EmpDeptJoin>)query.getResultList();
        em.close();
        return empList;
    }
}
