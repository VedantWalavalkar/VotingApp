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
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(unique = true)
    String username;
}
