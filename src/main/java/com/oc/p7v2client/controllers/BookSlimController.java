package com.oc.p7v2client.controllers;

import com.oc.p7v2client.beans.*;
import com.oc.p7v2client.proxies.BookSlimProxy;
import com.oc.p7v2client.proxies.BorrowProxy;
import com.oc.p7v2client.proxies.ReservationProxy;
import com.oc.p7v2client.proxies.UserProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@Log4j2
public class BookSlimController {
    private final BookSlimProxy bookSlimProxy;
    private final UserProxy userProxy;
    private final BorrowProxy borrowProxy;
    private final ReservationProxy reservationProxy;

    @GetMapping(value = "/books")
    public String listOfBooksSlims(Model model, @CookieValue(name = "jwtToken", required = false) String cookie) {
        log.info("HTTP GET request received at /books with listOfBooksSlims");
        List<BookSlimBean> bookSlimBeanList = bookSlimProxy.bookSlimBeanList();
        model.addAttribute("booksSlims", bookSlimBeanList);
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
    public String listOfBooksSlimsWithKeyWord(Model model, @RequestParam(value = "keyword") String keyword) {
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

    @PostMapping(value = "/books/reservation")
    public String makeAReservation(@CookieValue(name = "jwtToken") String cookie, @RequestParam Integer bookId,@RequestParam Integer userId,@RequestParam String bookTitle ) {
        log.info("HTTP GET request received at /books/reservation with makeAReservation");
        List<BorrowBean> borrowsFromUser = userProxy.findBorrowsByUserId(userId);
        for (BorrowBean borrow : borrowsFromUser) {
            log.info("HTTP GET request received at /books/reservation with makeAReservation for {} in for each where borrow title is {}", bookTitle, borrow.getBookTitle());
           if (borrow.getBookTitle().equals(bookTitle)){
               log.info("HTTP GET request received at /books/reservation with makeAReservation where bookTitle equals a bookAlreadyBorrow");
               return "/home";
           }
        }
        log.info("HTTP GET request received at /books/reservation with makeAReservation befor sending reservation");
        bookSlimProxy.makeAReservation(bookId,userId);
        return "redirect:/books";
    }
}
