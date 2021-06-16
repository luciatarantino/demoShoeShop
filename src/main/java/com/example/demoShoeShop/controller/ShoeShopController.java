package com.example.demoShoeShop.controller;

import com.example.demoShoeShop.DemoShoeShopApplication;
import com.example.demoShoeShop.dataTransfertObj.ModelDto;
import com.example.demoShoeShop.entities.Model;
import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.exceptions.ObjNotFoundException;
import com.example.demoShoeShop.services.ModelService;
import com.example.demoShoeShop.services.ShoeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoeShopController {
    @Autowired
    ModelService modelService;
    @Autowired
    ShoeService shoeService;

    private static final Logger log = LoggerFactory.getLogger(ShoeShopController.class);


    @GetMapping("/models")
    public ResponseEntity<List<Model>> getModels(){

        List<Model> l = modelService.findAll();
        return new ResponseEntity<List<Model>>(l, HttpStatus.OK);
    }

    @GetMapping("/models/{id}")
    public  ResponseEntity<Model> getModelById(@PathVariable(name = "id") int id){
        try{
            Model m = modelService.findById(id);
            return new ResponseEntity<Model>(m, HttpStatus.OK);
        } catch (ObjNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "object not found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePrice(@RequestParam(value = "id") Integer id, @RequestParam(value = "price") @Positive Float price){
        try{
            modelService.updatePrice(id,price);
            return new ResponseEntity<String>("SUCCESS - obj price updated", HttpStatus.OK);
        } catch (ObjNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "object not found");
        }
    }

    @PostMapping("/newmodel")
    public ResponseEntity<String> newModel(@Valid @RequestBody Model model){
        modelService.insert(model);
        return ResponseEntity.ok("SUCCESS - Valid model added correctly");
    }


//    @GetMapping("/storage")
//    public ResponseEntity<Map<Model, List<Shoe>>> allInStorage(){
//        Map<Model, List<Shoe>> storage = modelService.allInStorage();
//        return new ResponseEntity<Map<Model, List<Shoe>>>(storage, HttpStatus.OK);
//    }

//  ****** EFFETTO SPECCHIO **********
//    @GetMapping("/storage")
//        public ResponseEntity<Map<Integer, Model>> allInStorage(){
//        Map<Integer, Model> storage = modelService.allInStorage();
//        return new ResponseEntity<Map<Integer, Model>>(storage, HttpStatus.OK);
//    }
    //Map<Integer, ModelDto>

    @GetMapping("/storage")
        public ResponseEntity<Map<Integer, ModelDto>> allInStorage(){
        Map<Integer, ModelDto> storage = modelService.allInStorage();
        return new ResponseEntity<Map<Integer, ModelDto>>(storage, HttpStatus.OK);
    }

    @GetMapping("/storage2")
    public ResponseEntity<List<ModelDto>> allInStorage2(){
        List<ModelDto> storage = modelService.allInStorage2();
        return new ResponseEntity<List<ModelDto>>(storage, HttpStatus.OK);
    }

    @GetMapping("/shoes")
        public ResponseEntity<List<Shoe>> getShoes(){
        List<Shoe> shoeS = shoeService.allShoes();
        return new ResponseEntity<>(shoeS, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteModel(@RequestBody ModelDto m) throws ObjNotFoundException {
        log.info("barcode del modello " + m.getBarCode());
        log.info("description del modello " + m.getDescription());
        if(modelService.delete(m)){
            return new ResponseEntity<String>("SUCCESS - obj deleted", HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "object not found");
        }
    }

    @DeleteMapping("/deletecat")
    public ResponseEntity<String> deleteCatalogue(@RequestBody ModelDto m) {
        log.info("barcode del modello " + m.getBarCode());
        log.info("description del modello " + m.getDescription());
        try {
            modelService.deleteCatalogue(m);
            return new ResponseEntity<String>("SUCCESS - catalogue for model nr " + m.getBarCode() + " deleted", HttpStatus.OK);
        } catch (ObjNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "object not found - " + e.toString());
        }
    }


//  The @ExceptionHandler annotation allows us to handle specified types of exceptions through one single method.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
