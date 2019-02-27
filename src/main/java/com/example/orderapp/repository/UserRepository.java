package com.example.orderapp.repository;

import com.example.orderapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByUsername(User username);
}
