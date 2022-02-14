package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.LibraryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="P7-V2-API",url="localhost:8083")
public interface LibraryProxy {
    @GetMapping(value="/libraries")
    public List<LibraryBean> librariesList();
}
