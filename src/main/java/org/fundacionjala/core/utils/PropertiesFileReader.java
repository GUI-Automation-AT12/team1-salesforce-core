package org.fundacionjala.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.throwables.PropertiesReadingException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileReader.class);
    private final Properties property;
    private final FileReader reader;

    /**
     * Initializes an instance of properties files.
     * @param filePath path of the properties file
     */
    public PropertiesFileReader(final String filePath) throws PropertiesReadingException {
        try {
            reader = new FileReader(filePath);
            property = new Properties();
            property.load(reader);
        } catch (IOException e) {
            LOGGER.error("Error when reading file: " + filePath);
            LOGGER.error(e.getMessage());
            throw new PropertiesReadingException("Error when reading properties file: " + filePath);
        } finally {
            closeReader();
        }
    }

    /**
     * Gets environment property from file.
     * @param propertyName name of the property
     * @return property value.
     */
    public String getProperty(final String propertyName) throws PropertiesReadingException {
        String readProperty = this.property.getProperty(propertyName);
        if (readProperty != null) {
            return readProperty;
        } else {
            LOGGER.error("Error getting property: " + propertyName);
            throw new PropertiesReadingException("Error getting property: " + propertyName);
        }
    }

    private void closeReader() throws PropertiesReadingException {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            LOGGER.error("Cannot close file Reader.");
            throw new PropertiesReadingException("Cannot close File Reader.");
        }
    }
}
