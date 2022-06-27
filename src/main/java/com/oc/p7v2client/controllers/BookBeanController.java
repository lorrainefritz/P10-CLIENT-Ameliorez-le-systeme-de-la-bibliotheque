package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.*;
import com.oc.p7v2client.proxies.BookProxy;
import com.oc.p7v2client.proxies.UserProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class BookBeanController {
    private final BookProxy bookProxy;
    private final UserProxy userProxy;


    @GetMapping(value = "/books")
    public String listOfBooks(Model model, @CookieValue(name = "jwtToken", required = false) String cookie) {
        log.info("HTTP GET request received at /books with listOfBooksSlims");
        List<BookBean> bookBeanList = bookProxy.bookSlimBeanList();
        model.addAttribute("booksSlims", bookBeanList);
        model.addAttribute("keyword", new String());
        UserBean user = new UserBean();
        if (cookie != null) {
            user = userProxy.getUserFromToken(cookie);
            log.info("HTTP GET request received at /books with listOfBooksSlims where cookie isNotNull and user {}", user.getUsername());
        }
        model.addAttribute("user", user);
        return "booksList";
    }

    @GetMapping(value = "/books/search")
    public String listOfBooksWithKeyWord(Model model, @RequestParam(value = "keyword") String keyword) {
        log.info("HTTP GET request received at /books with listOfBooksSlimsWithKeyWord");
        if (keyword == null) {
            List<BookBean> booksSlims = bookProxy.bookSlimBeanList();
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", new String());
        } else {
            log.info("HTTP GET request received at /books with listOfBooksSlimsWithKeyWord WITH keyword : " + keyword);
            List<BookBean> booksSlims = bookProxy.booksSlimsListWithAKeyword(keyword);
            model.addAttribute("booksSlims", booksSlims);
            model.addAttribute("keyword", keyword);
        }
        return "booksList";
    }

    @PostMapping(value = "/books/reservation")
    public String makeAReservation(@CookieValue(name = "jwtToken") String cookie, @RequestParam Integer bookId,@RequestParam Integer userId,@RequestParam String bookTitle ) {
        log.info("HTTP GET request received at /books/reservation with makeAReservation");
        Boolean bookIsAlreadyBorrow = bookIsAlreadyBorrow(userId, bookTitle);
        if (bookIsAlreadyBorrow==true){
            log.info("in makeAReservation where bookAlreadyBorrow by user");
            return "redirect:/redirectionPageBadReservation";
        }
        log.info("HTTP GET request received at /books/reservation with makeAReservation befor sending reservation");
        bookProxy.makeAReservation(bookId,userId);
        return "redirect:/books";
    }

    private Boolean bookIsAlreadyBorrow(Integer userId, String bookTitle) {
        log.info("in bookIsAlreadyBorrow method");
        List<BorrowBean> borrowsFromUser = userProxy.findBorrowsByUserId(userId);
        for (BorrowBean borrow : borrowsFromUser) {
            log.info("in bookIsAlreadyBorrow method for {} in for each where borrow title is {}", bookTitle, borrow.getBookTitle());
           if (borrow.getBookTitle().equals(bookTitle)){
               log.info("in bookIsAlreadyBorrow method where bookTitle equals a bookAlreadyBorrow");
               return true;
           }
        }
        return false;
    }

    @GetMapping (value = "/redirectionPageBadReservation")
    public String redirectionPageBadReservation(){
        log.info("HTTP GET request received at /redirectionPageBadReservation");
        return "redirectionPageBadReservation";
    }
}
