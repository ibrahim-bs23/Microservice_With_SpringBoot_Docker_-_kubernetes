package com.practice.Accounts.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @Column(name = "nid", nullable = false, unique = true)
    private String nid;
    private String fullName;


}
