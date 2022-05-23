package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.UserBean;
import com.oc.p7v2client.cookie.CookieUtil;
import com.oc.p7v2client.proxies.UserProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class UserBeanController {
    private final UserProxy userProxy;
    private final CookieUtil cookieUtil;

    //penser à rajouter l'identification token...
    @GetMapping(value = "/login")
    public String authenticationForm(Model model, @CookieValue(name = "jwtToken", required = false) Cookie cookie) {
        if (cookie != null) {
            log.info("HTTP POST request received at /login with authenticate where token {} is present", cookie.getName());

            return "redirect:/users/account";
        } else {
            log.info("HTTP GET request received at /login with authenticationForm");
            model.addAttribute("username", new String());
            model.addAttribute("password", new String());
        }
        return "authenticationForm";
    }

    @PostMapping(value = "/login")
    public String authenticate(@CookieValue(name = "jwtToken", required = false) Cookie cookie, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletResponse response) {
        log.info("HTTP POST request received at /login with authenticate");
        String token = userProxy.authenticate(username, password);
        log.info("HTTP POST request received at /login with authenticate with token {}", token);
        cookie = cookieUtil.createCookie(token);
        response.addCookie(cookie);
        log.info("HTTP POST request received at /login with authenticate with cookie {}, with expiration date {}", cookie.getName(), new Date(System.currentTimeMillis() + 12 * 24 * 60 * 60 * 1000));
        return "redirect:/users/account";
    }
    @GetMapping(value ="/logout")
    public String logout(HttpServletResponse response){
        log.info("HTTP GET request received at /logout ");
        cookieUtil.deleteCookie(response);
        return "redirect:/login";
    }

    @GetMapping(value = "/users/account")
    /*public String getUserAccount(Model model, @CookieValue(name = "jwtToken", defaultValue = testToken) String cookie) {*/
    public String getUserAccount(Model model, @CookieValue(name = "jwtToken") String cookie) {
        log.info("HTTP GET request received at /users/account");
        if (cookie == null) {
            log.info("HTTP GET request received at /users/account with cookie is null");
            return "authenticationForm";
        } else {
            log.info("HTTP GET request received at /users/account with cookie is " + cookie);
            UserBean user = userProxy.getUserFromToken(cookie);
            model.addAttribute("user", user);
        }
        return "myAccount";
    }


}
