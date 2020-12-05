package com.sl.ems.repositories;

import com.sl.ems.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DepartmentRepository extends JpaRepository<Department, BigInteger> {

}
