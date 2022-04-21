package com.example.spring_data.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "account")
    private Integer account;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    public User(Integer id, String firstname, String lastname, Integer account, String phonenumber, String password, String username) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.account = account;
        this.phonenumber = phonenumber;
        this.password = password;
        this.username = username;
    }
}