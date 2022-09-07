package com.example.ejercicios7_8_9_spring.controller;

import com.example.ejercicios7_8_9_spring.entities.Laptop;
import com.example.ejercicios7_8_9_spring.repository.LaptopRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);


    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Operation(summary = "Buscar todos los laptops", description = "Buscar todos")
    @GetMapping("/api/laptop")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();
    }

    @Operation(summary = "Buscar laptop por id", description = "Id del laptop")
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

    }

    @Operation(summary = "Crear laptop", description = "Crear")
    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }

    @Operation(summary = "Actualizar laptop", description = "Actualizar")
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("trying to update a not existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("trying to update a not existent laptop");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Borrar laptop por id", description = "Id del laptop")
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("trying to delete a not existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Borrar todos los laptops", description = "Borrar todos")
    @DeleteMapping("/api/books")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for deleting all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

}
