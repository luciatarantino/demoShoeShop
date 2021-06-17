package com.example.demoShoeShop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //or IDENTITY
    @Column(name = "ID_USER")
    private int idUser;

    @Column(name = "USERNAME")
    @NotBlank
    private String username;

    @Column(name = "PASSWORD")
    @NotBlank
    //@Size(min = 5, max = 10)
    private String password;

    @Column(name = "NAME")
    @NotBlank
    private String name;

    @Column(name = "PERMISSION")
    private String permission;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.permission = "simpleUser";
    }

    public User(String username, String password, String name, String permission) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.permission = permission;
    }
}
