package com.demoproject.springbootdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data //lombok annotation to reduce boiler plate code usually by default adds getter and setters
@NoArgsConstructor //lombok annotation 
@AllArgsConstructor//lombok annotation 
@Builder//lombok annotation 
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    
    /*@Length(max = 5,min =1)
    @Size(max = 10, min = 0)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent*/
    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}