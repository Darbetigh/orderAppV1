package com.example.orderapp.service;

import com.example.orderapp.model.Item;
import com.example.orderapp.model.User;
import com.example.orderapp.model.UserAddDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    void addUser(UserAddDTO form);

    Iterable<User> getUsers();

    void deleteItemById(long id);

    List<String> getUsernames();

    User getUserByUsername(String username);

    User getUserByUsername(User username);

    Optional<User> getUserById(long id);

    Map<String, List<Item>> numberOfItemsByType(long userId);
}
