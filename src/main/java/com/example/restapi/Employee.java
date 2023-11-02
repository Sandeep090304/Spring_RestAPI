package com.example.restapi;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "e_mail")
    private String email;
}
