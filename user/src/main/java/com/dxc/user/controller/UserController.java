package com.dxc.user.controller;

import com.dxc.user.entity.UserEntity;
import com.dxc.user.service.UserService;
import com.dxc.user.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
//        String siteURL = Utility.getSiteURL(request);
//        userService.sendVerificationEmail(userEntity, siteURL);
        return ResponseEntity.ok().body(this.userService.createUser(userEntity));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody UserEntity userEntity){
        userEntity.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(userEntity));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteUser(@PathVariable long id){
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }
    @GetMapping("/users/username/{username}")
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<UserEntity>(userService.getUserByUsername(username), HttpStatus.OK);
    }
}
