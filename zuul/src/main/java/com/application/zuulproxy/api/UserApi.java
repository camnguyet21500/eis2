package com.application.zuulproxy.api;

import com.application.zuulproxy.model.Users;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("user")
public interface UserApi {

    @GetMapping(value = "/users/username/{username}")
    Users findUserByUsername(@RequestHeader @PathVariable("username") String username);
}
