package com.example.demoShoeShop.dataTransfertObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ModelDto {

    private Integer barCode;
    private String description;
    private String brand;
    private float price;
    List<ShoeDto> allShoe;
}
