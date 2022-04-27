package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.UserBean;
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

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class UserBeanController {
    private final UserProxy userProxy;

    private final String testToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXVsQGdtYWlsLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODMvbG9naW4iLCJleHAiOjE2NTEwNzc1MjB9.LorY_6omHKSSf7dfM3HJD6NotJE2ApIsJN5BJrgr6oY";

    //penser à rajouter l'identification token...
    @GetMapping(value = "/login")
    public String authenticationForm(Model model) {
        log.info("HTTP GET request received at /login with authenticationForm");
        model.addAttribute("username", new String());
        model.addAttribute("password", new String());
        return "authenticationForm";
    }

    @PostMapping(value = "/login")
    public String authenticate(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        log.info("HTTP POST request received at /login with authenticate");
        userProxy.authenticate(username, password);
        return "redirect:/users/account";
    }

    @GetMapping(value = "/users/account")
    public String getUserAccount(Model model, @CookieValue(name = "jwtToken", defaultValue = testToken) String token) {
        log.info("HTTP GET request received at /users/account");
        if (token == null) {
            log.info("HTTP GET request received at /users/account with token is null");
            return "authenticationForm";
        } else {
            log.info("HTTP GET request received at /users/account with token is " + token);
            UserBean user = userProxy.getUserFromToken(token);
            model.addAttribute("user", user);
        }
        return "myAccount";
    }


}
