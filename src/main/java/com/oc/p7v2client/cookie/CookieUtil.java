package com.oc.p7v2client.cookie;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
@Log4j2
@NoArgsConstructor
@Component
public class CookieUtil {

    public static final String COOKIE_NAME = "jwtToken";

    public static Cookie createCookie (String token){
        Cookie cookie = new Cookie(COOKIE_NAME,token);
        log.info("in CookieUtils in createCookie");
        cookie.setMaxAge(12 * 24 * 60 * 60); // expires in 12 days
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        log.info("in CookieUtils in createCookie after initializing it cookie name {} cookie domain {} cookie path {}", cookie.getName(), cookie.getDomain(),cookie.getPath() );
        return cookie;
    }

}
