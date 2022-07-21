package com.oc.p7v2client.proxies;

import com.oc.p7v2client.beans.BorrowBean;
import com.oc.p7v2client.beans.ReservationBean;
import com.oc.p7v2client.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/users/account/reservations/delete")
    public ResponseEntity deleteAReservation(@RequestParam Integer reservationId);
}
