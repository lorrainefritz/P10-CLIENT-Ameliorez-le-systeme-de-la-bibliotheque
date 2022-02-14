package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.BookSlimBean;
import com.oc.p7v2client.proxies.BookSlimProxy;
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
public class BookSlimController {
    private final BookSlimProxy bookSlimProxy;

    @GetMapping(value="/books")
    public String listOfBooksSlims(Model model){
        log.info("HTTP GET request received at /books with listOfBooksSlims");
        List<BookSlimBean> booksSlims = bookSlimProxy.bookSlimBeanList();
        model.addAttribute("booksSlims", booksSlims);
        return"booksList";
    }
}
