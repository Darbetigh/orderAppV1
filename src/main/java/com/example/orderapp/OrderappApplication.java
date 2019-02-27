package com.example.orderapp;

import com.example.orderapp.model.Item;
import com.example.orderapp.model.User;
import com.example.orderapp.repository.ItemRepository;
import com.example.orderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    public static void main(String[] args) {

        SpringApplication.run(OrderappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Item item1 = new Item("123S", "tempercam", "xtemper", "100", "100");
        Item item2 = new Item("358G", "tempercam", "ytemper", "200", "90");
        Item item3 =  new Item("158A", "tempercam", "ztemper", "300", "80");
        Item item4 = new Item("935C", "tempercam", "wtemper", "400", "70");

        User user1 = new User("sedo", "{noop}123456", "ahmet", "kara");
        User user2 = new User("hool", "{noop}hoo123", "mehmet", "ak");

        Set set1 = new HashSet<Item>();
        set1.add(item1);
        set1.add(item3);
        set1.add(item4);

        Set set2 = new HashSet<Item>();
        set2.add(item2);

        user1.setItems(set1);
        user2.setItems(set2);

        item1.setUser(user1);
        item3.setUser(user1);
        item4.setUser(user1);

        item2.setUser(user2);

        userRepository.save(user1);
        userRepository.save(user2);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
    }
}
