package com.app.Interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Interview.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
