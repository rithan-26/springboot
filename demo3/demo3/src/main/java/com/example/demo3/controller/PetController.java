package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.Pet;
import com.example.demo3.service.EventService;

@RestController
public class PetController {
    @Autowired
    EventService ms;

    @PostMapping("api/product")
    public ResponseEntity<Pet> addelements(@RequestBody Pet m) {
        Pet mm = ms.create(m);
        return new ResponseEntity<>(mm, HttpStatus.CREATED);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Pet>> showinfo() {
        return new ResponseEntity<>(ms.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Pet> getById(@PathVariable Integer productId) {
        Pet obj = ms.getMe(productId);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Pet> putMethodName(@PathVariable("productId") int id, @RequestBody Pet m) {
        if (ms.updateDetails(id, m) == true) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        }

        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id) {
        if (ms.deleteProduct(id) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/product/sortBy/{field}")
    public List<Pet> g(@PathVariable String field) {
        return ms.sort(field);
    }

    @GetMapping("/api/product/{offset}/{pagesize}")
    public List<Pet> get(@PathVariable int offset, @PathVariable int pagesize) {
        return ms.page(pagesize, offset);
    }

    // sorting and pagination
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public List<Pet> getsorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        return ms.getsort(offset, pagesize, field);
    }

    @GetMapping("/eventPlace")
    public List<Pet> getUsersWithEvents() {
        return ms.getUsersWithEvents();
    }

}
