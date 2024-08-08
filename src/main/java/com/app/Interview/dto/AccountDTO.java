package com.app.Interview.dto;

import java.time.LocalDateTime;

import com.app.Interview.entity.CurrencyEnum;

import lombok.Data;

@Data
public class AccountDTO {

  private String id;
  private PersonalInformationDTO information;
  private Double balance;
  private CurrencyEnum currency;
  private LocalDateTime createdAt;
}
