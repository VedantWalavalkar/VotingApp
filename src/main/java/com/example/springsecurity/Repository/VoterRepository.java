package com.example.springsecurity.Repository;

import com.example.springsecurity.Models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {
}
