package com.app.Interview.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  private String id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_information_id", referencedColumnName = "id")  
  private PersonalInformation information;

  @Column(name = "balance")
  private Double balance;

  @Column(name = "currency")
  private CurrencyEnum currency;

  @Column(name = "createdAt")
  private LocalDateTime createdAt;
}
