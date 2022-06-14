package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookSlimBean;
import com.oc.p7v2client.beans.ReservationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="P10-API",url="localhost:8083")
public interface ReservationProxy {
    @GetMapping(value ="/reservations")
    public List<ReservationBean> reservationBeanList();
    @GetMapping(value ="books/reservations")
   public List<ReservationBean> findReservationsByBookId(@RequestParam Integer bookId);
}
