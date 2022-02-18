package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.BookSlimBean;
import com.oc.p7v2client.proxies.BookSlimProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class BookSlimController {
    private final BookSlimProxy bookSlimProxy;

    @GetMapping(value = "/books")
    public String listOfBooksSlims(Model model) {
        log.info("HTTP GET request received at /books with listOfBooksSlims");
            List<BookSlimBean> booksSlims = bookSlimProxy.bookSlimBeanList();
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", new String());
        return "booksList";
    }

    @GetMapping(value = "/books/search")
    public String listOfBooksSlimsWithKeyWord(Model model, @RequestParam(value="keyword") String keyword) {
        log.info("HTTP GET request received at /books with listOfBooksSlimsWithKeyWord");
        if (keyword == null) {
            List<BookSlimBean> booksSlims = bookSlimProxy.bookSlimBeanList();
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", new String());
        } else {
            log.info("HTTP GET request received at /books with listOfBooksSlimsWithKeyWord WITH keyword : " + keyword);
            List<BookSlimBean> booksSlims = bookSlimProxy.booksSlimsListWithAKeyword(keyword);
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", keyword);
        }
        return "booksList";
    }


    /*@GetMapping(value="/books/{keyword}")
    public String listOfBooksSlims(Model model, @PathVariable String keyword){
        log.info("HTTP GET request received at /books with listOfBooksSlims");
       *//* if (keyword == null) {
            List<BookSlimBean> booksSlims = bookSlimProxy.bookSlimBeanList();
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", new String());
        }else{*//*
        log.info("HTTP GET request received at /books with listOfBooksSlims WITH keyword : " +keyword );
        List<BookSlimBean> booksSlims = bookSlimProxy.booksSlimsListWithAKeyword(keyword);
        model.addAttribute("booksSlims", booksSlims);
        model.addAttribute("keyword", new String());
        return"booksList";
    }*/


  /*  @PostMapping(value="/books/{keyword}")
    public String searchForABooksSlimsListWithAKeyword(@ModelAttribute String keyword){
        log.info("HTTP POST request received at /books/"+keyword+ "with searchForBooksSlimsList");
        bookSlimProxy.searchForABooksSlimsListWithAKeyword(keyword);
        return"redirect:/booksList";
    }*/
}
