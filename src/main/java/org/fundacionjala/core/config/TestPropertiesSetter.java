package org.fundacionjala.core.config;

import org.fundacionjala.core.selenium.interaction.WebDriverManager;
import org.fundacionjala.core.throwables.PropertiesReadingException;

/**
 * [MR] Class that sets Test Properties defined in the gradle.properties file.
 */
public final class TestPropertiesSetter {
    private TestPropertiesSetter() {
    }

    /**
     * Sets dataproviderthreadcount property.
     */
    public static void setDataProviderThreadCountProp() throws PropertiesReadingException {
        System.setProperty("dataproviderthreadcount", TestExecutionProperties.getInstance().getCucumberThreadCount());
    }

    /**
     * Sets the Test Browser to run test Scenarios.
     */
    public static void setTestBrowser() throws PropertiesReadingException {
        WebDriverManager.setBrowserName(TestExecutionProperties.getInstance().getTestBrowser());
    }
}
