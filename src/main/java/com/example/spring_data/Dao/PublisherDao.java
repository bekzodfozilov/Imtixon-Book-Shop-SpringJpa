package com.example.spring_data.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
public class PublisherDao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "publisherdao")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "adres_id",referencedColumnName = "id")
    private AddresDao addresDao;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "publisherDao")
    private List<BookDao> bookDaos;

    public PublisherDao(Integer id, String name, AddresDao addresDao, List<BookDao> bookDaos) {
        this.id = id;
        this.name = name;
        this.addresDao = addresDao;
        this.bookDaos = bookDaos;
    }
}
