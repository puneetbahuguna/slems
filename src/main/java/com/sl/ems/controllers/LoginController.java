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

   @Autowired
   private LoginService loginService;
   @Autowired
   private SessionComponent sessionComponent;

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
    @RequestMapping("relogin")
    public String reLogin(HttpSession session,Model model){
        session.removeAttribute("userid");
        session.removeAttribute("name");
        session.removeAttribute("role");
        session.invalidate();
        model.addAttribute("message","Welcome to EMS");
        return "redirect:"+getLoginPage(session,model);
    }
    @RequestMapping("logintry")
    public String loginError(Model model){
        model.addAttribute("message","Welcome to EMS");
        model.addAttribute("errormsg","Either Username or Password is incorrect");
        return "login";
    }

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
