package com.example.spring_data.Repository;

import com.example.spring_data.Dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao , Integer> {

}
