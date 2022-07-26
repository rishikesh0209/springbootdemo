package com.demoproject.springbootdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //lombok annotation to reduce boiler plate code
@Entity //making it a jpa entity
@Table(name="employee")
public class Employee {
    @Id //annotation to make id a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false)
    private String firstname;

    @Column(name="lastname",nullable = true)
    private String lastname;

    @Column(name="email",nullable = true)

    private String email;
}
