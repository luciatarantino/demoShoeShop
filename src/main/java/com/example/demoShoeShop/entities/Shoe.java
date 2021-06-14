package com.example.demoShoeShop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "SHOES")
//@Data -> sostituisce tutte le annotazione nelle due righe sotto
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Shoe {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "ID")
     private int id;

     @ManyToOne
     @JoinColumn(name = "BAR_CODE")
     @Valid
     private Model model;

     @Column(name = "COLOR")
     @NotBlank
     private String color;

     @Column(name = "EU_NUMBER")
     @Min(value = 14) @Max(value = 49)
     private int euNumber;

     @Column(name = "QUANTITY")
     @PositiveOrZero
     private int quantity;

     public Shoe(Model model, String color, int euNumber, int quantity) {
          this.model = model;
          this.color = color;
          this.euNumber = euNumber;
          this.quantity = quantity;
     }


}
