package com.example.spring_data.Repository;

import com.example.spring_data.Dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
