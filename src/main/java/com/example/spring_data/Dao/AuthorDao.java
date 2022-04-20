package com.example.spring_data.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
public class AuthorDao{
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Authordao")
    @Column(name = "id")
    private Integer id;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    public AuthorDao(String birthdate, String firstname, String lastname) {
        this.id = id;
        this.birthdate = birthdate;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
