package org.fundacionjala.core.config;

import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExecutionPropertiesTest {

    /**
     * Testing getting Single Instance of TestExecutionProperties class.
     * @throws PropertiesReadingException
     */
    @Test
    public void testTestExecutionPropertiesTestGetInstance() throws PropertiesReadingException {
        Assert.assertNotNull(TestExecutionProperties.getInstance());
    }

    /**
     * Test getting the testBrowser property from gradle.properties file.
     * @throws PropertiesReadingException
     */
    @Test
    public void testGettingTestBrowserProperty() throws PropertiesReadingException {
        String browser = TestExecutionProperties.getInstance().getTestBrowser();
        Assert.assertNotNull(browser);
    }

    /**
     * Test getting the filterTags property from gradle.properties file.
     * @throws PropertiesReadingException
     */
    @Test
    public void testGettingFilterTagsProperty() throws PropertiesReadingException {
        String filterTags = TestExecutionProperties.getInstance().getFilterTags();
        Assert.assertNotNull(filterTags);
    }

    /**
     * Test getting the cucumberThreadCount property from gradle.properties file.
     * @throws PropertiesReadingException
     */
    @Test
    public void testGettingCucumberThreadCountProperty() throws PropertiesReadingException {
        String cucumberThreadCount = TestExecutionProperties.getInstance().getCucumberThreadCount();
        Assert.assertNotNull(cucumberThreadCount);
    }
}
