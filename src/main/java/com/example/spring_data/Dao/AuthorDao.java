package com.example.spring_data.Dao;

import com.example.spring_data.Dto.BookDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "authorDao")
    private List<BookDao> bookDaos;

    public AuthorDao(Integer id, String birthdate, String firstname, String lastname, List<BookDao> bookDaos) {
        this.id = id;
        this.birthdate = birthdate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bookDaos = bookDaos;
    }
}
