package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BookSlimBean;
import com.oc.p7v2client.beans.BorrowBean;
import com.oc.p7v2client.beans.ReservationBean;
import com.oc.p7v2client.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import java.util.List;

@FeignClient(name="P10-API",url="localhost:8083")
public interface UserProxy {
    @PostMapping(value="/login")
    public String authenticate(@RequestParam(value="username") String username, @RequestParam(value="password") String password);

    @GetMapping(value="/users/account")
    public UserBean getUserFromToken(@CookieValue(value ="jwtToken")String token);

    @GetMapping(value = "users/borrowsFromUserId")
    public List<BorrowBean> findBorrowsByUserId(@RequestParam Integer userId);

    @GetMapping(value = "/users/account/reservations")
    List<ReservationBean> reservationList(@CookieValue(value ="jwtToken")String token);

    @PostMapping("/users/account/reservations/delete")
    void deleteAReservation(@RequestParam Integer reservationId);
}
