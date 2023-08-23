package com.example.springsecurity.Controllers;

import com.example.springsecurity.Models.Voter;
import com.example.springsecurity.Service.UserService;
import com.example.springsecurity.Service.VoterService;
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
@RequestMapping("/voter")
public class VoterController {

    @Autowired
    UserService userService;

    @Autowired
    VoterService voterService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to voter place";
    }

    @PutMapping("/voting")
    public ResponseEntity voteForCandidate(@RequestParam int voterId, @RequestParam int candId) throws Exception{
        try{
            voterService.voteForCandidate(voterId, candId);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Vote registered successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
