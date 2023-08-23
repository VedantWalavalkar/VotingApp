package com.example.springsecurity.Service;

import com.example.springsecurity.DTO.Response.VoteCountResponse;
import com.example.springsecurity.Models.Vote;
import com.example.springsecurity.Repository.AdminRepository;
import com.example.springsecurity.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    VoteRepository voteRepository;
    public VoteCountResponse getVoteCount() {
        List<Vote> votes = voteRepository.findAll();
        int cand1=0, cand2=0, cand3=0, cand4=0;
        for(Vote vote : votes){
            if(vote.isCand1()) cand1++;
            else if(vote.isCand2()) cand2++;
            else if(vote.isCand3()) cand3++;
            else if(vote.isCand4()) cand4++;
        }

        return VoteCountResponse.builder()
                .cand1(cand1)
                .cand2(cand2)
                .cand3(cand3)
                .cand4(cand4)
                .build();
    }
}
