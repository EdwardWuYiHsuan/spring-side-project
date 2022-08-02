package com.edward.spring.service.impl;

import com.edward.spring.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public int getItemById(int id) {
        System.out.println("Item(id=" + id + ", name=cell phone)");
        return ++id;
    }
}
