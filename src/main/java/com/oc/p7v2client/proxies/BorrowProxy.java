package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BorrowBean;
import com.oc.p7v2client.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P7-V2-API",url="localhost:8083")
public interface BorrowProxy {
    @GetMapping(value = "users/account/borrows")
    public List<BorrowBean> borrowList(@RequestParam Integer userId);
}
