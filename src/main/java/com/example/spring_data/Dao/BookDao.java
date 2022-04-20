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

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher_id")
    private Integer publisher_id;

    public BookDao(Integer id, String nameUZ,  BigDecimal cost, String publishedDate, Integer page_count, Integer author_id, String genre, Integer publisher_id) {
        this.id = id;
        this.nameUZ = nameUZ;
        this.cost = cost;
        this.publishedDate = publishedDate;
        this.page_count = page_count;
        this.author_id = author_id;
        this.genre = genre;
        this.publisher_id = publisher_id;
    }
}
