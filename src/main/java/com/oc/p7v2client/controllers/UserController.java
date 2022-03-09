package com.oc.p7v2client.controllers;

import com.oc.p7v2client.proxies.UserProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class UserController {
    private final UserProxy userProxy;

    @GetMapping(value = "/login")
    public String authenticationForm(Model model) {
        log.info("HTTP GET request received at /login with authenticationForm");
        model.addAttribute("username",new String());
        model.addAttribute("password",new String());
        return "authenticationForm";
    }
    @PostMapping(value="/login")
    public void authenticate(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
        log.info("HTTP POST request received at /login with authenticate");
        userProxy.authenticate(username,password);
        /*return "redirect:/myAccount";*/
    }
}
