package com.example.demoShoeShop.repositories;

import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
    //User findByUsername();
}
