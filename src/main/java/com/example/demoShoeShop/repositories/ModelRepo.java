package com.example.demoShoeShop.repositories;

import com.example.demoShoeShop.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ModelRepo extends JpaRepository <Model, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE MODELS SET PRICE = :price WHERE BAR_CODE = :id", nativeQuery = true)
    void updatePrice(@RequestParam(value = "id") Integer id,@RequestParam(value = "price") Float price);

    /*
    * SELECT SHOES.ID, BAR_CODE_M, BRAND, DESCRIPTION, COLOR, EU_NUMBER, PRICE FROM MODELS
    * INNER JOIN SHOES ON BAR_CODE_M = BAR_CODE_S
    * ORDER BY BAR_CODE_M ASC
    * */



}
