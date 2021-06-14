package com.example.demoShoeShop.services;

import com.example.demoShoeShop.dataTransfertObj.ModelDto;
import com.example.demoShoeShop.entities.Model;
import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.exceptions.ObjNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ModelService {

    List<Model> findAll();
    Model findById(Integer id) throws ObjNotFoundException;

    //Da qui in poi vanno sviluppati e soprattutto implementati di validazione
    void updatePrice(Integer id, Float price) throws ObjNotFoundException;
    void insert(Model model);

    boolean delete(ModelDto m) throws ObjNotFoundException;

    void deleteCatalogue(ModelDto m) throws ObjNotFoundException;

//    Map<Model, List<Shoe>> allInStorage();

//    //  ****** EFFETTO SPECCHIO **********
      //Map<Integer, Model> allInStorage();

    Map<Integer, ModelDto> allInStorage();

    List<ModelDto> allInStorage2();

}
