package com.example.springsecurity.Service;

import com.example.springsecurity.Exception.VoterNotFoundException;
import com.example.springsecurity.Models.Vote;
import com.example.springsecurity.Models.Voter;
import com.example.springsecurity.Repository.VoteRepository;
import com.example.springsecurity.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterService {
    @Autowired
    VoterRepository voterRepository;
    public void voteForCandidate(int voterId, int candId) {
        Optional<Voter> optionalVoter = voterRepository.findById(voterId);
        if(optionalVoter.isEmpty())
            throw new VoterNotFoundException("Voter not found");
        Voter voter = optionalVoter.get();
        Vote vote = voter.getVote();

        if(candId == 1)
            vote.setCand1(true);
        else if (candId == 2)
            vote.setCand2(true);
        else if (candId == 3)
            vote.setCand3(true);
        else if (candId == 4)
            vote.setCand4(true);

        voterRepository.save(voter);
    }
}
