package com.example.spring_data.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "adres_id")
    private Integer adres_id;

    public PublisherDao(String name, Integer adres_id) {
        this.id = id;
        this.name = name;
        this.adres_id = adres_id;
    }
}
