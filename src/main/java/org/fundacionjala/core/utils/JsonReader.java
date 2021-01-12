package org.fundacionjala.core.utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * [SL] This class read a json file.
 */
public final class JsonReader {
    /**
     * Constructor.
     */
    private JsonReader() {

    }
    /**
     * Returns a Map<String, String> of a json file.
     * @param jsonPath
     * @return a Map<String, String> of the elements.
     */
    public static Map<String, Map<String, String>> getJsonAsMap(final String jsonPath) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(jsonPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Map<String, Map<String, String>> mapElements = new HashMap<String, Map<String, String>>();
        mapElements = gson.fromJson(bufferedReader, mapElements.getClass());
        return mapElements;
    }
}
