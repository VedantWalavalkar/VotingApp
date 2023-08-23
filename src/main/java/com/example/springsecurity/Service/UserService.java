package com.example.springsecurity.Service;

import com.example.springsecurity.Models.Admin;
import com.example.springsecurity.Models.User;
import com.example.springsecurity.Models.Vote;
import com.example.springsecurity.Models.Voter;
import com.example.springsecurity.Repository.AdminRepository;
import com.example.springsecurity.Repository.UserRepository;
import com.example.springsecurity.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    VoterRepository voterRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void addAdmin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles("ROLE_ADMIN");

        userRepository.save(user);

        Admin admin = new Admin();
        admin.setUsername(username);
        adminRepository.save(admin);

    }

    public void registerVoter(Voter voter) {
        User user = new User();
        user.setUsername(voter.getUsername());
        user.setPassword(passwordEncoder.encode(voter.getPassword()));
        user.setRoles("ROLE_VOTER");
        userRepository.save(user);

        Vote vote = new Vote();
        voter.setVote(vote);
        vote.setVoter(voter);
        Voter savedVoter = voterRepository.save(voter);
    }

}
