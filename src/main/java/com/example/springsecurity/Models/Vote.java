package com.example.springsecurity.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Vote {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    boolean cand1;

    boolean cand2;

    boolean cand3;

    boolean cand4;

    @JoinColumn
    @OneToOne
    Voter voter;
}
