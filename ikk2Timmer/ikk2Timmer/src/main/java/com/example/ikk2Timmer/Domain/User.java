package com.example.ikk2Timmer.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


}
