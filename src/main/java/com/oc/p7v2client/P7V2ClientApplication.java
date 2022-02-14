package com.oc.p7v2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.oc.p7v2client.proxies")
@SpringBootApplication
public class P7V2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(P7V2ClientApplication.class, args);
    }

}
