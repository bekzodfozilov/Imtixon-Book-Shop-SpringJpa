package com.example.spring_data.Repository;

import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDao,Integer > {


}
