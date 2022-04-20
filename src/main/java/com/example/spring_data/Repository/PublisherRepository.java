package com.example.spring_data.Repository;

import com.example.spring_data.Dao.PublisherDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherDao,Integer> {

}
