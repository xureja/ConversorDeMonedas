package com.lcastillodv.conversormonedas.principal;

import com.lcastillodv.conversormonedas.modelos.ConversionHistory;
import com.lcastillodv.conversormonedas.modelos.CurrencyConverter;
import com.lcastillodv.conversormonedas.modelos.SupportedCurrencies;
import com.lcastillodv.conversormonedas.services.ExchangeRate;
import com.lcastillodv.conversormonedas.services.ExchangeRateApiClient;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final ExchangeRateApiClient apiClient;
    private final CurrencyConverter converter;
    private final ConversionHistory historyManager;

    public Menu(ExchangeRateApiClient apiClient, CurrencyConverter converter, ConversionHistory historyManager) {
        this.apiClient = apiClient;
        this.converter = converter;
        this.historyManager = historyManager;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        try {
            ExchangeRate rates = apiClient.fetchExchangeRates();
            List<String> supportedCurrencies = SupportedCurrencies.CURRENCIES;

            System.out.println("*** Bienvenido al Conversor de Monedas ***");
            while (true) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Ver lista de monedas");
                System.out.println("2. Realizar conversión");
                System.out.println("3. Ver historial de conversiones");
                System.out.println("4. Salir");
                System.out.print("Ingrese su opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (option) {
                    case 1:
                        System.out.println("\nMonedas disponibles:");
                        supportedCurrencies.forEach(System.out::println);
                        break;

                    case 2:
                        System.out.println("\nMonedas disponibles para conversión:");
                        supportedCurrencies.forEach(System.out::println);

                        System.out.print("Seleccione la moneda de destino: ");
                        String targetCurrency = scanner.nextLine().toUpperCase();

                        if (!supportedCurrencies.contains(targetCurrency)) {
                            System.out.println("Moneda no válida. Inténtelo nuevamente.");
                            continue;
                        }

                        System.out.print("Ingrese el monto en USD: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer

                        if (!rates.getConversion_rates().containsKey(targetCurrency)) {
                            System.out.println("No se encontraron tasas de cambio para la moneda seleccionada.");
                            continue;
                        }

                        double rate = rates.getConversion_rates().get(targetCurrency);
                        double convertedAmount = converter.convert(amount, rate);

                        System.out.printf("Monto convertido: %.2f %s%n", convertedAmount, targetCurrency);

                        String conversion = String.format("USD %.2f -> %s %.2f", amount, targetCurrency, convertedAmount);
                        historyManager.saveConversion(conversion);
                        break;

                    case 3:
                        System.out.println("\nHistorial de conversiones:");
                        List<String> history = historyManager.loadHistory();
                        if (history.isEmpty()) {
                            System.out.println("No hay conversiones registradas.");
                        } else {
                            history.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.println("¡Gracias por usar el Conversor de Monedas!");
                        return;

                    default:
                        System.out.println("Opción no válida. Inténtelo nuevamente.");
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}
