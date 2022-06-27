package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P10-API",url="localhost:8083")
public interface BookProxy {
   @GetMapping(value="/books")
    public List<BookBean> bookSlimBeanList();
   @GetMapping(value="/books/search")
   public List<BookBean> booksSlimsListWithAKeyword(@RequestParam(value="keyword") String keyword);
    @PostMapping("/books/reservation")
    public void makeAReservation(@RequestParam Integer bookId, @RequestParam Integer userId);
}
