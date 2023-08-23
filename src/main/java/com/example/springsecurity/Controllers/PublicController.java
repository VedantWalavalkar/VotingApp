package com.example.springsecurity.Controllers;

import com.example.springsecurity.Models.Voter;
import com.example.springsecurity.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to public place";
    }

    @PostMapping("/addAdmin")
    public ResponseEntity addAdmin(@RequestParam String username, @RequestParam String password){
        userService.addAdmin(username, password);
        return new ResponseEntity("Admin added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity registerVoter(@RequestBody Voter voter){
        userService.registerVoter(voter);
        return new ResponseEntity("Voter registered", HttpStatus.CREATED);
    }

//    @GetMapping("/logout")
//    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
//    }
}
