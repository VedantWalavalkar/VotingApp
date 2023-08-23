package com.example.springsecurity.Controllers;

import com.example.springsecurity.Models.Voter;
import com.example.springsecurity.Service.UserService;
import com.example.springsecurity.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
