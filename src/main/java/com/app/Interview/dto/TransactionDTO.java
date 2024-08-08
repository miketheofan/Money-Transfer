package com.app.Interview.dto;

import com.app.Interview.entity.CurrencyEnum;

import lombok.Data;

@Data
public class TransactionDTO {

  private String sourceAccountId;
  private String targetAccountId;
  private Double amount;
  private CurrencyEnum currency;
}
