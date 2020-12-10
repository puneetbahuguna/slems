package com.sl.ems.services;

import com.sl.ems.models.Department;
import com.sl.ems.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This service class handles add department functionality.
     **/
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartmentList(){
        return departmentRepository.findAll();
    }

    /** This method adds new department in the department table**/
    public boolean addDepartment(Department addDept){
        try {
            departmentRepository.save(addDept);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
