package com.sl.ems.repositories;

import com.sl.ems.models.Login_Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface LoginRepository extends JpaRepository<Login_Master, BigInteger> {

    @Query(value = "select * from login_master WHERE USERID=?1 and PASSWORD=?2",nativeQuery = true)
    Login_Master findUserByIdPassword(BigInteger UserId, String password);
}
