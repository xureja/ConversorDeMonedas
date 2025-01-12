package com.lcastillodv.conversormonedas.principal;

import com.lcastillodv.conversormonedas.modelos.ConversionHistory;
import com.lcastillodv.conversormonedas.modelos.CurrencyConverter;
import com.lcastillodv.conversormonedas.services.ExchangeRateApiClient;

public class Main {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6f2be532fbf817acaa8882e8/latest/USD";

    public static void main(String[] args) {
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient(API_URL);
        CurrencyConverter converter = new CurrencyConverter();
        ConversionHistory historyManager = new ConversionHistory();

        Menu menu = new Menu(apiClient, converter, historyManager);
        menu.display();
    }
}
