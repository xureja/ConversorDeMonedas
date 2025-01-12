package com.lcastillodv.conversormonedas.services;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateApiClient {
    private final String apiUrl;

    public ExchangeRateApiClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public ExchangeRate fetchExchangeRates() throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        Gson gson = new Gson();
        return gson.fromJson(response.toString(), ExchangeRate.class);
    }
}
