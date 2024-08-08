package com.app.Interview.util;

import com.app.Interview.entity.CurrencyEnum;

public class CurrencyConverter {

  /* Exchange rates as of 2024-06-25 13:58:18 */
  private static final Double EURO_TO_USD = 1.0714;
  private static final Double EURO_TO_GBP = 0.8580;
  private static final Double EURO_TO_JPY = 144.66;

  private static final Double USD_TO_EURO = 0.9334;
  private static final Double USD_TO_GBP = 0.8007;
  private static final Double USD_TO_JPY = 134.96;

  private static final Double JPY_TO_EURO = 0.00691;
  private static final Double JPY_TO_USD = 0.00741;
  private static final Double JPY_TO_GBP = 0.00593;
  
  private static final Double GBP_TO_EURO = 1.1651;
  private static final Double GBP_TO_USD = 1.2487;
  private static final Double GBP_TO_JPY = 168.63;

  
  public static Double currencyConverter(Double amount, CurrencyEnum accountCurrency, CurrencyEnum transactionCurrency) throws Exception{

    if(accountCurrency == transactionCurrency) {
      return amount;
    }

    switch (transactionCurrency) {
      case EURO:
        return convertFromEuro(amount, accountCurrency);
      case USD:
        return convertFromUSD(amount, accountCurrency);
      case GBP:
        return convertFromGBP(amount, accountCurrency);
      case JPY:
        return convertFromJPY(amount, accountCurrency);
      default:
        throw new Exception("Unsupported currency: " + accountCurrency);
    }
  }

  private static Double convertFromEuro(Double amount, CurrencyEnum toCurrency) throws Exception {
    switch (toCurrency) {
      case USD:
        return amount * EURO_TO_USD;
      case GBP:
        return amount * EURO_TO_GBP;
      case JPY:
        return amount * EURO_TO_JPY;
      default:
        throw new Exception("Unsupported target currency: " + toCurrency);
    }
  }

  private static Double convertFromUSD(Double amount, CurrencyEnum toCurrency) throws Exception {
    switch (toCurrency) {
      case EURO:
        return amount * USD_TO_EURO;
      case GBP:
        return amount * USD_TO_GBP;
      case JPY:
        return amount * USD_TO_JPY;
      default:
        throw new Exception("Unsupported target currency: " + toCurrency);
    }
  }

  private static Double convertFromGBP(Double amount, CurrencyEnum toCurrency) throws Exception {
    switch (toCurrency) {
      case EURO:
        return amount * GBP_TO_EURO;
      case USD:
        return amount * GBP_TO_USD;
      case JPY:
        return amount * GBP_TO_JPY;
      default:
        throw new Exception("Unsupported target currency: " + toCurrency);
    }
  }

  private static Double convertFromJPY(Double amount, CurrencyEnum toCurrency) throws Exception {
    switch (toCurrency) {
      case EURO:
        return amount * JPY_TO_EURO;
      case USD:
        return amount * JPY_TO_USD;
      case GBP:
        return amount * JPY_TO_GBP;
      default:
        throw new Exception("Unsupported target currency: " + toCurrency);
    }
  }
}
