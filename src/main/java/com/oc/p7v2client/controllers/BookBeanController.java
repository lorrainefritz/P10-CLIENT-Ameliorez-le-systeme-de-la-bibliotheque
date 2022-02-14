package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.BookBean;
import com.oc.p7v2client.proxies.BookProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class BookBeanController {
    private final BookProxy bookProxy;
/*    @GetMapping(value="/books/get/{id}")
    public String bookDetails(@PathVariable Integer id, Model model){
        log.info("HTTP GET request received at /books/get/"+id+ " with findAllBooks");
        BookBean book = bookProxy.bookBean(id);
        model.addAttribute("book", book);
        return "bookDetails";
    }*/

}
