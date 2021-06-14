package com.example.demoShoeShop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MODELS")
@NoArgsConstructor //@AllArgsConstructor
@Getter @Setter
public class Model {
    @Id
    @Positive
    @Column(name = "BAR_CODE")
    private Integer barCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BRAND")
    @NotBlank
    private String brand;

    @Column(name = "PRICE")
    @Positive
    private float price;

//    così hybernate mi crea una tabella di relazione tra MODELS.BAR_CODE e SHOES.ID
//    @OneToMany
//    List<Shoe> allShoe;

    public Model(Integer barCode, String description, String brand, float price) {
        this.barCode = barCode;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return barCode.equals(model.barCode) && brand.equals(model.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode, brand);
    }
}
