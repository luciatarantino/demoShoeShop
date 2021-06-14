package com.example.demoShoeShop.repositories;


import com.example.demoShoeShop.entities.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoeRepo extends JpaRepository<Shoe, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM SHOES WHERE BAR_CODE = :barCode", nativeQuery = true)
    void DeleteShoesPerModel(@RequestParam(value = "barCode") Integer barCode);

}
