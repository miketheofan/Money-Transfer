package com.app.Interview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.Interview.dto.TransactionDTO;
import com.app.Interview.entity.Account;
import com.app.Interview.entity.Transaction;
import com.app.Interview.repository.AccountRepository;
import com.app.Interview.repository.TransactionRepository;
import com.app.Interview.util.CurrencyConverter;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  AccountRepository accountRepository;

  public void transfer(TransactionDTO transactionDTO) throws Exception{

    Optional<Account> sourceAccount = accountRepository.findById(transactionDTO.getSourceAccountId());
    Optional<Account> targetAccount = accountRepository.findById(transactionDTO.getTargetAccountId());

    if(!sourceAccount.isPresent()) {
      throw new Exception("Source account does not exist!");
    }

    if(!targetAccount.isPresent()) {
      throw new Exception("Target account does not exist!");
    }

    if(sourceAccount.get().getId() == targetAccount.get().getId()) {
      throw new Exception("Source and Target account must not be the same!");
    }

    Double transactionAmount = CurrencyConverter.currencyConverter(transactionDTO.getAmount(), sourceAccount.get().getCurrency(), transactionDTO.getCurrency());

    if(sourceAccount.get().getBalance() - transactionAmount < 0) {
      throw new Exception("Account has insufficient funds!");
    }

    Double newSourceBalance = sourceAccount.get().getBalance()-transactionAmount;
    sourceAccount.get().setBalance(newSourceBalance);
    accountRepository.save(sourceAccount.get());

    transactionAmount = CurrencyConverter.currencyConverter(transactionDTO.getAmount(), targetAccount.get().getCurrency(), transactionDTO.getCurrency());

    Double newTargetBalance = targetAccount.get().getBalance()+transactionAmount;
    targetAccount.get().setBalance(newTargetBalance);
    accountRepository.save(targetAccount.get());

    Transaction transaction = Transaction.mapFromDTO(transactionDTO);
    transactionRepository.save(transaction);
  }

  public List<Transaction> retrieve() {
    return transactionRepository.findAll();
  }
}
