package com.example.springsecuritydemo.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "First Name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*",message = "First name contains illegal characters")
    private String firstName;


    @NotBlank(message = "Last Name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*",message = "Last name contains illegal characters")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "[0-9\\-+]*",message = "Phone number contains illegal characters")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address contains illegal characters")
    private String address;


    @NotBlank(message = "Cubicle No cannot be empty.")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",message = "Cubicle No contains illegal characters.")
    private String cubicleNo;



    public Employee() {

    }

}
