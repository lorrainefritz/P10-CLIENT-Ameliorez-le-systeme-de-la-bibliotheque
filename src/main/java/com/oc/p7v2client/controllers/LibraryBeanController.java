package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.BookSlimBean;
import com.oc.p7v2client.beans.LibraryBean;
import com.oc.p7v2client.proxies.BookSlimProxy;
import com.oc.p7v2client.proxies.LibraryProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class LibraryBeanController {

    private final LibraryProxy libraryProxy;

    @GetMapping(value = "/libraries")
    public String listOflibraries(Model model) {
        log.info("HTTP GET request received at /libraries with listOflibraries");
        List<LibraryBean> librariesBeans = libraryProxy.librariesList();
        model.addAttribute("libraries", librariesBeans);
        return "libraries";
    }
}