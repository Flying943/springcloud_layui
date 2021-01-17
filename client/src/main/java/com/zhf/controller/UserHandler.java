package com.zhf.controller;

import com.zhf.entity.User;
import com.zhf.entity.UserVo;
import com.zhf.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;


    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
    }



    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }


    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }
}
