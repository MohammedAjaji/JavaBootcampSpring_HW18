package com.example.spring_homework18.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty ")
    @Size(min = 5, message = "name should be more than 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username cannot be empty ")
    @Size(min = 5, message = "username should be more than 4")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty ")
    @Size(min = 8, message = "password should be at lest size 8")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Email
    @NotEmpty(message = "email cannot be empty ")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be empty ")
    @Column(columnDefinition = "varchar(20) not null check ( role = 'user' or role = 'admin') ")
    private String role;

    @NotNull(message = "age cannot be empty ")
    @Min(value = 18, message = "have to be 18+")
    @Column(columnDefinition = "int not null")
    private Integer age;
}