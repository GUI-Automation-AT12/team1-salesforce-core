package org.fundacionjala.core.config;

import org.fundacionjala.core.selenium.interaction.WebDriverManager;
import org.fundacionjala.core.throwables.PropertiesReadingException;

/**
 * [MR] Class that sets Test Properties defined in the gradle.properties file.
 */
public class TestPropertiesSetter {
    private TestPropertiesSetter() {
    }

    /**
     * Sets dataproviderthreadcount property.
     *
     * @param threadCount defined number for threadCount
     */
    public static void setDataProviderThreadCountProp(final String threadCount) throws PropertiesReadingException {
        System.setProperty("dataproviderthreadcount", TestExecutionProperties.getInstance().getCucumberThreadCount());
    }

    /**
     * Sets the Test Browser to run test Scenarios.
     *
     * @param browserName name of default browser
     */
    public static void setTestBrowser(final String browserName) throws PropertiesReadingException {
        WebDriverManager.setBrowserName(TestExecutionProperties.getInstance().getTestBrowser());
    }
}
