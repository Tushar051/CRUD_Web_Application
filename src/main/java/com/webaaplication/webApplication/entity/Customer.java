package com.webaaplication.webApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // how will create id
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "First Name is required")
    @Size(min = 1, message = "Name length should be more than 1 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Column(name = "email")
    @Email
    private String email;

    @NotEmpty(message = "Phone should not be empty")
    @Column(name = "phone_no")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
