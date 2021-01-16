package org.fundacionjala.core.config;

import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.core.utils.PropertiesFileReader;

/**
 * [MR] Class in charge to read gradle.properties file and its defined properties.
 */
public final class TestExecutionProperties {

    private static final String PROPERTIES_FILE_NAME = "gradle.properties";
    private static TestExecutionProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;
    private static String rootPath = "";

    /**
     * If singleInstance was not instanced before it creates a new one, otherwise returns the created.
     * @return singleInstance
     */
    public static TestExecutionProperties getInstance() throws PropertiesReadingException {
        if (singleInstance == null) {
            singleInstance = new TestExecutionProperties();
        }
        return singleInstance;
    }

    private TestExecutionProperties() throws PropertiesReadingException {
        propertiesFileReader = new PropertiesFileReader(rootPath + PROPERTIES_FILE_NAME);
    }

    /**
     * Defines the root path from where the properties file should be taken.
     * @param root
     */
    public static void setRootPath(final String root) {
        rootPath = root;
    }

    /**
     * Gets the cucumberThreadCount from the properties file.
     * @return cucumberThreadCount value
     */
    public String getCucumberThreadCount() throws PropertiesReadingException {
        return propertiesFileReader.getProperty("cucumberThreadCount");
    }

    /**
     * Gets the filterTags from the properties file.
     * @return filterTags value
     */
    public String getFilterTags() throws PropertiesReadingException {
        return propertiesFileReader.getProperty("filterTags");
    }

    /**
     * Gets the testBrowser from the properties file.
     * @return testBrowser value
     */
    public String getTestBrowser() throws PropertiesReadingException {
        return propertiesFileReader.getProperty("testBrowser");
    }
}
