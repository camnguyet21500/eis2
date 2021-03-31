package com.example.invoice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "user")
public interface UserApi {
    @GetMapping("/users")
     List getAllUser();

}
