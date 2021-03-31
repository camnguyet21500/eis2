package com.dxc.user.repository;

import com.dxc.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsername(String username);

//    @Query("UPDATE User c SET c.active = true WHERE c.id = ?1")
//    @Modifying
//    public void active(Integer id);
//
//    @Query("SELECT c FROM User c WHERE c.verification_code = ?1")
//    public UserEntity findByVerificationCode(String code);

}
