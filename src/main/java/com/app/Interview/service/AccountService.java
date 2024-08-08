package com.app.Interview.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.Interview.dto.AccountDTO;
import com.app.Interview.entity.Account;
import com.app.Interview.entity.PersonalInformation;
import com.app.Interview.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class AccountService {

  @Autowired
  AccountRepository accountRepository;

  public Account add(AccountDTO accountDTO) {

    PersonalInformation personalInformation = new PersonalInformation();
    personalInformation.setEmail(accountDTO.getInformation().getEmail());
    personalInformation.setFirstName(accountDTO.getInformation().getFirstName());
    personalInformation.setLastName(accountDTO.getInformation().getLastName());

    Account account = new Account();
    account.setBalance(accountDTO.getBalance());
    account.setCurrency(accountDTO.getCurrency());
    account.setInformation(personalInformation);
    account.setCreatedAt(LocalDateTime.now());

    this.accountRepository.save(account);

    return account;
  }

  public List<Account> retrieve() {
    return this.accountRepository.findAll();
  }

}
