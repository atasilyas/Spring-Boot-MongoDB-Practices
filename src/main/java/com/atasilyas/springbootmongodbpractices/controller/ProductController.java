package com.atasilyas.springbootmongodbpractices.controller;


import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "findAll",
            method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        try {
            return ResponseEntity.ok(productService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "find/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Product> find(@PathVariable ObjectId id) {
        try {
            return ResponseEntity.ok(productService.find(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "create",
            method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Product product) {
        try {
            productService.create(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "update",
            method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Product product) {
        try {
            productService.update(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        try {
            productService.delete(productService.find(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
