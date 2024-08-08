package com.app.Interview.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import com.app.Interview.dto.TransactionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  private String id;

  @Column(name = "sourceAccountId")
  private String sourceAccountId;

  @Column(name = "targetAccountId")
  private String targetAccountId;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "currency")
  private CurrencyEnum currency;

  @Column(name = "transactionTime")
  private LocalDateTime transactionTime;

  public static Transaction mapFromDTO(TransactionDTO transactionDTO) {
    
      Transaction transaction = new Transaction();
      transaction.setAmount(transactionDTO.getAmount());
      transaction.setCurrency(transactionDTO.getCurrency());
      transaction.setSourceAccountId(transactionDTO.getSourceAccountId());
      transaction.setTargetAccountId(transactionDTO.getTargetAccountId());
      transaction.setTransactionTime(LocalDateTime.now());

      return transaction;
  }
}
