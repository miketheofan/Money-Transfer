package com.app.Interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Interview.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
