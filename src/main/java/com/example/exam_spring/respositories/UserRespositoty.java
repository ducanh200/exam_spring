package com.example.exam_spring.respositories;

import com.example.exam_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRespositoty extends JpaRepository<User,Long> {

    List<User> findAllByNameContaining(String name);
}
