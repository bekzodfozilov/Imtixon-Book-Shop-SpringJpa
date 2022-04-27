package com.example.spring_data.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class BookDao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookdao")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nameuz")
    private String nameUZ;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "published_date")
    private String publishedDate;

    @Column(name = "page_count")
    private Integer page_count;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auhtor_id",referencedColumnName = "id")
    private AuthorDao authorDao;

    @Column(name = "genre")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private PublisherDao publisherDao;

    public BookDao(Integer id, String nameUZ, BigDecimal cost, String publishedDate, Integer page_count, AuthorDao authorDao, String genre, PublisherDao publisherDao) {
        this.id = id;
        this.nameUZ = nameUZ;
        this.cost = cost;
        this.publishedDate = publishedDate;
        this.page_count = page_count;
        this.authorDao = authorDao;
        this.genre = genre;
        this.publisherDao = publisherDao;
    }


}
