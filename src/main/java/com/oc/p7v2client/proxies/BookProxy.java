package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="P7-V2-API",url="localhost:8083")
public interface BookProxy {

}
