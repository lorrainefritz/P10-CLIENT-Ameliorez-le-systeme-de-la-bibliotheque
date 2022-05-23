package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.BorrowBean;
import com.oc.p7v2client.beans.UserBean;
import com.oc.p7v2client.proxies.BorrowProxy;
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

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class BorrowBeanController {
    private final UserProxy userProxy;
    private final BorrowProxy borrowProxy;

    @GetMapping(value="/users/account/borrows")
    public String listOfBorrows(Model model,@CookieValue(name = "jwtToken") String cookie){
        log.info("HTTP GET request received at /users/account/borrows with listOfBorrows");
        if (cookie == null) {
            log.info("HTTP GET request received at /users/account/borrows with cookie is null");
            return "authenticationForm";
        } else {

            List<BorrowBean> borrows = borrowProxy.borrowList(cookie);
            model.addAttribute("borrows", borrows);
            model.addAttribute("borrowId", new String());
        }
       return "borrowsList";
    }

    @PostMapping("/users/account/borrows/extend")
    public String extendABorrow(@RequestParam(value = "borrowId")Integer borrowId,@CookieValue(name = "jwtToken") String cookie){
        log.info("HTTP GET request received at /users/account/borrows/extend with listOfBorrows");
        if (cookie == null) {
            log.info("HTTP POST request received at /users/account/borrows/extend with cookie is null");
            return "authenticationForm";
        } else{
            log.info("HTTP POST request received at /users/account/borrows/extend with cookie is {} and borrowId is {}", cookie,borrowId);
            borrowProxy.extendABorrow(borrowId);
        }
        return "redirect:/users/account/borrows";
    }

}
