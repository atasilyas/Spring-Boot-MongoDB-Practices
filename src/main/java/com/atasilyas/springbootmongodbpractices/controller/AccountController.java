package com.atasilyas.springbootmongodbpractices.controller;

import com.atasilyas.springbootmongodbpractices.model.Account;
import com.atasilyas.springbootmongodbpractices.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {



    private final AccountService accountService;

    @RequestMapping(value = "findAll",
            method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll() {
        try {
            return ResponseEntity.ok(accountService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "find/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Optional<Account>> find(@PathVariable String id) {
        try {
            return ResponseEntity.ok(accountService.find(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "create",
            method = RequestMethod.POST)
    public ResponseEntity<Account> create(@RequestBody Account account) {
        try {
            return ResponseEntity.ok(accountService.save(account));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            accountService.find(id).orElseThrow(Exception::new);
            accountService.find(id).ifPresent(account -> accountService.delete(account));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    
    
}
