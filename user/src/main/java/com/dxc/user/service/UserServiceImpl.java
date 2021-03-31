package com.dxc.user.service;

import com.dxc.user.entity.UserEntity;
import com.dxc.user.exception.ResourceNotFoundException;
import com.dxc.user.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    JavaMailSender mailSender;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setActive(true);
//
//        String randomCode = RandomString.make(64);
//        userEntity.setVerification_code(randomCode);

        return userRepository.save(userEntity);


    }

//    @Override
//    public void sendVerificationEmail(UserEntity userEntity, String siteURL) throws UnsupportedEncodingException, MessagingException {
//        String subject = "Please verify your registration";
//        String senderName = "E-Invoice System";
//        String mailContent = "<p>Dear" + userEntity.getFullname() + ",</p>";
//        mailContent += "<p>Please click the link below to verify to your registration:</p>";
//        String verifyURL = siteURL + "/verify?code=" + userEntity.getVerification_code();
//        mailContent += "<h3><a href=\"" + siteURL + "\">VERIFY</a>";
//        mailContent += "<p>Thank you!<br>E-Invoice System.</p>";
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom("camnguyet.huflit@gmail.com", senderName);
//        helper.setTo(userEntity.getEmail());
//        helper.setSubject(subject);
//        helper.setText(mailContent, true);
//
//        mailSender.send(message);
//    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userEntity.getId());

        if(userEntityOptional.isPresent()) {
            UserEntity userUpdate = userEntityOptional.get();
            userUpdate.setActive(userEntity.isActive());
            userUpdate.setUsername(userEntity.getUsername());
            userUpdate.setPassword(userEntity.getPassword());
            userUpdate.setFullname(userEntity.getFullname());
            userUpdate.setAddress(userEntity.getAddress());
            userUpdate.setEmail(userEntity.getEmail());
            userUpdate.setLimit_consume(userEntity.getLimit_consume());
            userUpdate.setRole(userEntity.setRole("USER"));
            userRepository.save(userUpdate);
            return userUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userEntity.getId());
        }

    }

    @Override
    public List<UserEntity> getAllUser() {

        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);

        if(userEntityOptional.isPresent()) {
            return userEntityOptional.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(long userId) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findById(userId);

        if(userEntityOptional.isPresent()) {
            this.userRepository.delete(userEntityOptional.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id: " + userId);
        }
    }

    @Override
    public UserEntity getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

//    @Override
//    public boolean verify(String verification_code){
//        UserEntity userEntity = userRepository.findByVerificationCode(verification_code);
//        if(userEntity == null || userEntity.isActive()){
//            return false;
//        }else{
//            userRepository.active((int) userEntity.getId());
//            return true;
//        }
//    }
}
