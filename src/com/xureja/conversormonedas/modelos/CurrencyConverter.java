package com.lcastillodv.conversormonedas.modelos;

public class CurrencyConverter {
    public double convert(double amount, double rate) {
        return amount * rate;
    }
}
