package com.ehome.user_server.dao;

import com.ehome.user_server.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface UserDao extends JpaRepository<UserInfo,Long> {


}
