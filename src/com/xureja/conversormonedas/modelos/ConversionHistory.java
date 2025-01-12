package com.lcastillodv.conversormonedas.modelos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private static final String HISTORY_FILE = "conversion_history.json";
    private final Gson gson = new Gson();

    public void saveConversion(String conversion) throws IOException {
        List<String> history = loadHistory();
        history.add(conversion);
        try (Writer writer = new FileWriter(HISTORY_FILE)) {
            gson.toJson(history, writer);
        }
    }

    public List<String> loadHistory() {
        try (Reader reader = new FileReader(HISTORY_FILE)) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo de historial", e);
        }
    }
}
