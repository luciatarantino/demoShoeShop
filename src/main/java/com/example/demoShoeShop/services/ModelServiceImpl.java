package com.example.demoShoeShop.services;

import com.example.demoShoeShop.dataTransfertObj.ModelDto;
import com.example.demoShoeShop.dataTransfertObj.ShoeDto;
import com.example.demoShoeShop.entities.Model;
import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.exceptions.ObjNotFoundException;
import com.example.demoShoeShop.repositories.ModelRepo;
import com.example.demoShoeShop.repositories.ShoeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepo modelRepo;
    @Autowired
    ShoeRepo shoeRepo;


    @Override
    public List<Model> findAll() {
        return modelRepo.findAll();
    }

    @Override
    public Model findById(Integer id) throws ObjNotFoundException {
        Optional<Model> modelOpt = modelRepo.findById(id);
        if (modelOpt.isPresent()){
            Model m = modelOpt.get();
            return m;
        }else{
            throw new ObjNotFoundException("The Model you want do not exists");
        }
    }
    //Da qui in poi vanno sviluppati e soprattutto implementati di validazione
    @Override
    public void updatePrice(Integer id, Float price) throws ObjNotFoundException {
        if(modelRepo.findById(id).isPresent()){
        modelRepo.updatePrice(id,price);
        }else{
            throw new ObjNotFoundException("Obj with ID" + id + "not found");
        }
    }


    @Override
    public void insert(Model model) {
        modelRepo.save(model);
    }

    @Override
    public boolean delete(ModelDto m) throws ObjNotFoundException {
        Optional<Model> modOpt = modelRepo.findById(m.getBarCode());
        if(modOpt.isPresent()){
            Model model = modOpt.get();
            modelRepo.delete(model);
            return true;
        }else{
            throw new ObjNotFoundException("Obj with ID" + m.getBarCode() + "not found");
        }

    }

    @Override
    public void deleteCatalogue(ModelDto m) throws ObjNotFoundException {
        Optional<Model> modelOpt = modelRepo.findById(m.getBarCode());
        if (modelOpt.isPresent()){
            Model model = modelOpt.get();
            shoeRepo.DeleteShoesPerModel(model.getBarCode());
            modelRepo.delete(model);
        }else{
            throw new ObjNotFoundException("The Model you want do not exists");
        }
    }

    @Override
    public Map<Integer, ModelDto> allInStorage() {
        Map<Integer, ModelDto> storage = new HashMap<Integer, ModelDto>();
        List<Model> modelS = modelRepo.findAll();
        List<Shoe> shoeS = shoeRepo.findAll();
        for (Model m : modelS) {
            ModelDto mt = new ModelDto();
            mt.setBarCode(m.getBarCode());
            mt.setDescription(m.getDescription());
            mt.setBrand(m.getBrand());
            mt.setPrice(m.getPrice());
            List<ShoeDto> allShoesOfModel = new ArrayList<ShoeDto>();

            for (Shoe s :shoeS) {
                if(s.getModel().getBarCode() == m.getBarCode()){
                    ShoeDto st = new ShoeDto();
                    st.setId(s.getId());
                    st.setColor(s.getColor());
                    st.setEuNumber(s.getEuNumber());
                    st.setQuantity(s.getQuantity());
                    allShoesOfModel.add(st);
                }
            }

            mt.setAllShoe(allShoesOfModel);
            storage.put(mt.getBarCode(),mt);
        }
        return storage;
    }

    @Override
    public List<ModelDto> allInStorage2() {
        List<ModelDto> storage = new ArrayList<>();
        List<Model> modelS = modelRepo.findAll();
        List<Shoe> shoeS = shoeRepo.findAll();
        for (Model m : modelS) {
            ModelDto mt = new ModelDto();
            mt.setBarCode(m.getBarCode());
            mt.setDescription(m.getDescription());
            mt.setBrand(m.getBrand());
            mt.setPrice(m.getPrice());
            List<ShoeDto> allShoesOfModel = new ArrayList<ShoeDto>();

            for (Shoe s :shoeS) {
                if(s.getModel().getBarCode() == m.getBarCode()){
                    ShoeDto st = new ShoeDto();
                    st.setId(s.getId());
                    st.setColor(s.getColor());
                    st.setEuNumber(s.getEuNumber());
                    st.setQuantity(s.getQuantity());
                    allShoesOfModel.add(st);
                }
            }

            mt.setAllShoe(allShoesOfModel);
            storage.add(mt);
        }
        return storage;
    }

//    //  ****** EFFETTO SPECCHIO **********
//    @Override
//    public Map<Integer, Model> allInStorage() {
//        Map<Integer, Model> storage = new HashMap<Integer, Model>();
//        List<Model> modelS = modelRepo.findAll();
//        List<Shoe> shoeS = shoeRepo.findAll();
//        for (Model m : modelS) {
//            List<Shoe> allShoesOfModel = new ArrayList<Shoe>();
//            for (Shoe s : shoeS) {
//                if(s.getModel().equals(m)){
//                    allShoesOfModel.add(new Shoe());
//                }
//            }
//            m.setAllShoe(allShoesOfModel);
//            storage.put(m.getBarCode(), m);
//        }
//        return storage;
//    }

//    @Override
//    public Map<Model, List<Shoe>> allInStorage() {
//        Map<Model, List<Shoe>> storage = new HashMap<Model, List<Shoe>>();
//        List<Model> modelS = modelRepo.findAll();
//        List<Shoe> shoeS = shoeRepo.findAll();
//        for (Model m : modelS
//             ) {
//            List<Shoe> allShoesOfModel = new ArrayList<Shoe>();
//            for (Shoe s : shoeS
//                 ) {
//                if(m.getBarCode().equals(s.getBarCode())){
//                    allShoesOfModel.add(s);
//                }
//                storage.put(m, allShoesOfModel);
//            }
//
//        }
//        return storage;
//    }
}
