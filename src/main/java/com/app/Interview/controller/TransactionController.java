package com.app.Interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Interview.dto.TransactionDTO;
import com.app.Interview.handler.ResponseHandler;
import com.app.Interview.service.TransactionService;

@RestController
@RequestMapping(value = "/api/transfer", produces = "application/json")
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  /* Endpoint for money transfer */
  @PostMapping()
  public ResponseEntity<?> transfer(@RequestBody TransactionDTO transactionDTO) {
    
        try {
          transactionService.transfer(transactionDTO);

          return ResponseHandler
            .generateResponse("Transaction completed succesfully.", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseHandler
            .generateResponse("Transaction cannot be completed.", HttpStatus.BAD_REQUEST, e.getMessage());

        }
  }

  /* Optional endpoint for retrieving a list of all recorded transfers */
  @GetMapping()
  public ResponseEntity<?> retrieve() {
    return ResponseEntity
      .ok().body(this.transactionService.retrieve());
  }

}
