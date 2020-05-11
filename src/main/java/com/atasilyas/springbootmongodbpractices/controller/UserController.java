package com.atasilyas.springbootmongodbpractices.controller;

import com.atasilyas.springbootmongodbpractices.advice.BusinessException;
import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.model.User;
import com.atasilyas.springbootmongodbpractices.service.UserServiceCriteria;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceCriteria userServiceCriteria;

    @RequestMapping(value = "findAll",
            method = GET)
    public ResponseEntity<List<User>> findAll() {
        try {
            return ResponseEntity.ok(userServiceCriteria.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "find/{id}",
            method = GET)
    public ResponseEntity<User> find(@PathVariable ObjectId id) {
        try {
            return ResponseEntity.ok(userServiceCriteria.find(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "create",
            method = POST)
    public ResponseEntity<?> create(@RequestBody User user) {
            userServiceCriteria.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @RequestMapping(value = "update",
            method = PUT)
    public ResponseEntity<Void> update(@RequestBody User user) {
        try {
            userServiceCriteria.update(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "delete/{id}",
            method = DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            userServiceCriteria.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



    @RequestMapping(value = "contains",
            method = GET)
    public ResponseEntity<List<User>> findByNameContains(@RequestParam String regex) {
        try {
            return ResponseEntity.ok(userServiceCriteria.findByNameContains(regex));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "and",
            method = GET)
    public ResponseEntity<List<User>> findByAgeAndAccount(@RequestParam int age, @RequestParam String accountId) {
        try {
            return ResponseEntity.ok(userServiceCriteria.findByAgeAndAccount(age, accountId));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(value = "or",
            method = GET)
    public ResponseEntity<List<User>> findByAgeAndAccount(@RequestParam int age, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(userServiceCriteria.findByAgeOrProduct(age, product));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
