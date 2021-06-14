package com.example.demoShoeShop.dataTransfertObj;

import com.example.demoShoeShop.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ShoeDto {

    private int id;
    private String color;
    private int euNumber;
    private int quantity;

}
