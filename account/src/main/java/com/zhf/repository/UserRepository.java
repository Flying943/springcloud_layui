package com.zhf.repository;

import com.zhf.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User login(String username,String password);
}
