package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookBean;
import com.oc.p7v2client.beans.BookSlimBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P10-API",url="localhost:8083")
public interface BookSlimProxy {
   @GetMapping(value="/books")
    public List<BookSlimBean> bookSlimBeanList();
   @GetMapping(value="/books/search")
   public List<BookSlimBean> booksSlimsListWithAKeyword(@RequestParam(value="keyword") String keyword);
    @GetMapping("/books/findById")
    BookBean getABookFromId(@RequestParam Integer bookId);
    @PostMapping("/books/reservation")
    public void makeAReservation(@RequestParam Integer bookId, @RequestParam Integer userId);
}
