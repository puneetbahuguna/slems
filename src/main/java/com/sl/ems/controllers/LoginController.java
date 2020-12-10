package com.sl.ems.controllers;

import com.sl.ems.models.LoginUser;
import com.sl.ems.models.Login_Master;
import com.sl.ems.services.LoginService;
import com.sl.ems.utils.SessionComponent;
import com.sl.ems.utils.UtilConstants;
import com.sl.ems.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Controller
public class LoginController {

    /**
     Author: Puneet Kumar Bahuguna
     Year: DEC 2020
     Project: SimplyLearn EMS
     Description: This controller class handles the Login functionality.
     **/

   @Autowired
   private LoginService loginService;
   @Autowired
   private SessionComponent sessionComponent;

   /**Mapping of home page which redirects to the login page**/
   @RequestMapping({"/","login"})
    public String getLoginPage(HttpSession session,Model model){
        if(sessionComponent.isAdminSession() || sessionComponent.isEmpSession()){
            String role = session.getAttribute("role").toString();
            return "redirect:"+role;
        }else{
            model.addAttribute("message","Welcome to EMS");
            return "login";
        }
    }

    /**If session expires or user logged out it redirects to the login page again and remove the user session.**/
    @RequestMapping("relogin")
    public String reLogin(HttpSession session,Model model){
        session.removeAttribute("userid");
        session.removeAttribute("name");
        session.removeAttribute("role");
        session.invalidate();
        model.addAttribute("message","Welcome to EMS");
        return "redirect:"+getLoginPage(session,model);
    }

    /**This method is called if users enters wrong login credentials, from here
     * user again redirected to the login page with error message**/
    @RequestMapping("logintry")
    public String loginError(Model model){
        model.addAttribute("message","Welcome to EMS");
        model.addAttribute("errormsg","Either Username or Password is incorrect");
        return "login";
    }

    /**This method checks for login, validate userid and password entered by the user from the database,
     * if user is valid then it sets the session of user**/
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String checkLogin(HttpSession session, @RequestParam("userid") String userid,
                             @RequestParam("password") String password){
        Login_Master login_master=new Login_Master();
        login_master.setUSERID(new BigInteger(userid));
        login_master.setPassword(Utils.getBase64Encoding(password));
        LoginUser userInfo = loginService.getLoggedInUser(login_master);
        if(userInfo.getValidCredentials()){
            session.setAttribute("userid",userInfo.getUSERID());
            session.setAttribute("name",userInfo.getFIRSTNAME()+" "+userInfo.getLASTNAME());
            session.setAttribute("role",userInfo.getROLE());
            session.setAttribute("deptid",userInfo.getDEPARTMENT_ID());
            session.setMaxInactiveInterval(2*60*60);
              if(userInfo.getROLE().equals(UtilConstants.ADMIN_ROLE)){
                  return "redirect:admin";
              }else return "redirect:employee";
        }
        return "redirect:logintry";
    }

}
