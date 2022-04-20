package com.example.spring_data.Repository;

import com.example.spring_data.Dao.AuthorDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorDao,Integer> {
}
