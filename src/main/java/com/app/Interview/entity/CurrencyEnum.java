package com.app.Interview.entity;

public enum CurrencyEnum {

  USD,
  EURO,
  JPY,
  GBP;

  @Override
  public String toString() {
    switch(this) {
      case USD:
        return "USD";
      case EURO:
        return "EURO";
      case JPY:
        return "JPY";
      case GBP:
        return "GBP";
      default:
        throw new IllegalArgumentException();
    }
  }

}
