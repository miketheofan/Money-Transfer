package com.app.Interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Interview.dto.AccountDTO;
import com.app.Interview.entity.Account;
import com.app.Interview.handler.ResponseHandler;
import com.app.Interview.service.AccountService;

@RestController
@RequestMapping(value = "/api/account", produces = "application/json")
public class AccountController {

  @Autowired
  AccountService accountService;

  /* Endpoint for adding a new account */
  @PostMapping()
  public ResponseEntity<?> add(@RequestBody AccountDTO accountDTO) {

    Account account = this.accountService.add(accountDTO);
    if(account == null) {
      return ResponseHandler
            .generateResponse("Could not create account.", HttpStatus.BAD_REQUEST, null);
    } else {
      return ResponseHandler
            .generateResponse("Account created succesfully.", HttpStatus.OK, null);
    }
  }

  /* Endpoint for retrieving a list of all accounts */
  @GetMapping()
  public ResponseEntity<?> retrieve() {
    return ResponseEntity
      .ok().body(this.accountService.retrieve());
  }
}
