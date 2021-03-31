package com.dxc.user.service;

import com.dxc.user.entity.UserEntity;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);

//    void sendVerificationEmail(UserEntity userEntity, String siteURL) throws UnsupportedEncodingException, MessagingException;

    UserEntity updateUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(long userId);

    void deleteUser(long Id);

    UserEntity getUserByUsername(String username);

//    boolean verify(String verification_code);
}
