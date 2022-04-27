package com.example.spring_data.Dao;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class AddresDao {
    @Id
    @GeneratedValue(generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq",sequenceName = "address_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "district_id")
    private Integer district_id;

    @Column(name = "street")
    private String street;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "addresDao")
    private PublisherDao publisherDao;

}
