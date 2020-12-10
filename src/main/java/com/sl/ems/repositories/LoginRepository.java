package com.sl.ems.repositories;

import com.sl.ems.models.Login_Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 Author: Puneet Kumar Bahuguna
 Year: DEC 2020
 Project: SimplyLearn EMS
 Description: This Repository interface handles loading of login_master data from the database.
 **/
public interface LoginRepository extends JpaRepository<Login_Master, BigInteger> {

    @Query(value = "select * from login_master WHERE USERID=?1 and PASSWORD=?2",nativeQuery = true)
    Login_Master findUserByIdPassword(BigInteger UserId, String password);

    @Query(value = "select PASSWORD from login_master WHERE USERID=?1",nativeQuery = true)
    String findEmpPWDById(BigInteger UserId);

    @Transactional
    @Modifying
    @Query(value = "update login_master set PASSWORD=?1 WHERE USERID=?2",nativeQuery = true)
    void editLoginMaster(String password,BigInteger userId);

    @Transactional
    @Modifying
    @Query(value = "delete from login_master WHERE USERID=?1",nativeQuery = true)
    void deleteUser(BigInteger userId);
}
