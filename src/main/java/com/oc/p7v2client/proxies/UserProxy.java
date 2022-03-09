package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookSlimBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P7-V2-API",url="localhost:8083")
public interface UserProxy {
    @PostMapping(value="/login")
    public void authenticate(@RequestParam(value="username") String username, @RequestParam(value="password") String password);
}
