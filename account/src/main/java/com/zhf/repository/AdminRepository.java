package com.zhf.repository;

import com.zhf.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
    public Admin login(String username,String password);
}
