package com.example.demoShoeShop.services;

import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.repositories.ShoeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoeServiceImpl implements ShoeService{

    @Autowired
    ShoeRepo shoeRepo;

    @Override
    public List<Shoe> allShoes() {
         return shoeRepo.findAll();
    }
}
