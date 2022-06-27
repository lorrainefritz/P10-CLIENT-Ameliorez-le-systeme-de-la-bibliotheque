package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BorrowBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P10-API",url="localhost:8083")
public interface BorrowProxy {
    @GetMapping(value = "users/account/borrows")
    public List<BorrowBean> borrowList(@CookieValue(value ="jwtToken")String token);
    @PostMapping(value="/users/account/borrows/extend")
    public BorrowBean extendABorrow(@RequestParam Integer borrowId);

    @GetMapping(value = "/borrowById/")
    BorrowBean getABorrowById(@RequestParam Integer borrowId);
}
