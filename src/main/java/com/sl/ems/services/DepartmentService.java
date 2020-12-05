package com.sl.ems.services;

import com.sl.ems.models.Department;
import com.sl.ems.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getDepartmentList(){
        return departmentRepository.findAll();
    }

    public boolean addDepartment(Department addDept){
        try {
            departmentRepository.save(addDept);
            return true;
        }catch (Exception e){}
        return false;
    }
}
