package com.sl.ems.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Component
public class SessionComponent {
    @Autowired
    private HttpSession httpSession;

    public Model getSessionModel(Model model){
        model.addAttribute("fullname",httpSession.getAttribute("name"));
        model.addAttribute("empid",httpSession.getAttribute("userid"));
        model.addAttribute("userrole",httpSession.getAttribute("role"));
        return model;
    }

    public boolean isAdminSession(){
        return httpSession.getAttributeNames().hasMoreElements() &&
                httpSession.getAttribute("role").toString().equals(UtilConstants.ADMIN_ROLE);
    }
    public boolean isEmpSession() {
        return httpSession.getAttributeNames().hasMoreElements() &&
                httpSession.getAttribute("role").toString().equals(UtilConstants.EMP_ROLE);
    }
    public BigInteger getSessionUserDeptId(){
        return new BigInteger(httpSession.getAttribute("deptid").toString());
    }
    public BigInteger getSessionUserId(){
        return new BigInteger(httpSession.getAttribute("userid").toString());
    }

}
