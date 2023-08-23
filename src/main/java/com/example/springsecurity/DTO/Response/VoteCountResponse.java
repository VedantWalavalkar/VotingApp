package com.example.springsecurity.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteCountResponse {
    int cand1;

    int cand2;

    int cand3;

    int cand4;
}
