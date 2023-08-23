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
public class Voter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String username;

    String password;

    String emailId;

    String phoneNo;

    @OneToOne(mappedBy = "voter", cascade = CascadeType.ALL)
    Vote vote;
}
