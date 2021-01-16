package org.fundacionjala.core.selenium.browsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.core.utils.PropertiesFileReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [MR] Class in charge of Parse Json file data to a list of Browser objects and return them as a Map.
 */
public final class BrowserParser {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileReader.class);

    private static Map<String, Browser> browserMap;
    private static final String JSON_FILE_PATH =
            "../salesforce-core/src/main/java/org/fundacionjala/core/selenium/browsers/config/BrowserProperties.json";

    private BrowserParser() {
    }

    private static List<Browser> getBrowsersListFromJson() throws PropertiesReadingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(JSON_FILE_PATH), new TypeReference<>() { });
        } catch (IOException e) {
            LOGGER.error("Error when reading file: " + JSON_FILE_PATH);
            LOGGER.error(e.getMessage());
            throw new PropertiesReadingException("Error when reading json file: " + JSON_FILE_PATH);
        }
    }

    /**
     * Get a Map of Browsers from json file.
     * @return browserMap
     */
    public static Map<String, Browser> getBrowsersMap() {
        if (browserMap == null) {
            browserMap =  new HashMap<>();
            try {
                for (Browser browser: getBrowsersListFromJson()) {
                    browserMap.put(browser.getName(), browser);
                }
            } catch (PropertiesReadingException e) {
                //If the browsers properties json file is not found, the application should broke.
                System.exit(1);
            }
        }
        return browserMap;
    }
}
