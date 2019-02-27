package com.example.orderapp.service;

import com.example.orderapp.model.Item;
import com.example.orderapp.model.ItemAddDTO;

import java.util.Optional;

public interface ItemService {

    void addItem(ItemAddDTO form);

    void addItem(ItemAddDTO form, String user);

    Iterable<Item> getItems();

    void deleteItemById(long id);

    Optional<Item> getItemById(long id);

    Item assignItem(String username, long itemId);

    //void editItem(ItemAddForm form);
}
