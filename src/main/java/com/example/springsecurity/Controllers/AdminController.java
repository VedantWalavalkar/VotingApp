package com.example.springsecurity.Controllers;

import com.example.springsecurity.DTO.Response.VoteCountResponse;
import com.example.springsecurity.Service.AdminService;
import com.example.springsecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to admin place";
    }

    @GetMapping("/voteCount")
    public VoteCountResponse getVoteCount(){
        return adminService.getVoteCount();
    }
}
