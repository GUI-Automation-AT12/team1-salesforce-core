package org.fundacionjala.core.utils;

import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertiesFileReaderTest {

    /**
     * Test PropertiesFileReader correct Instantiation with correct file.
     * @throws PropertiesReadingException
     */
    @Test
    public void propertiesFileReaderInstantiationWithCorrectFileTest() throws PropertiesReadingException {
        final String CORRECT_FILE = "gradle.properties";
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(CORRECT_FILE);
        Assert.assertNotNull(propertiesFileReader);
    }

    /**
     * Test PropertiesFileReader incorrect Instantiation with incorrect file.
     * @throws PropertiesReadingException
     */
    @Test(expectedExceptions = PropertiesReadingException.class,
            expectedExceptionsMessageRegExp = "Error when reading properties file: gradle.prop")
    public void propertiesFileReaderInstantiationWithIncorrectFileTest() throws PropertiesReadingException {
        final String INCORRECT_FILE = "gradle.prop";
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(INCORRECT_FILE);
    }

    /**
     * Test to get correct property from a correct file.
     * @throws PropertiesReadingException
     */
    @Test
    public void gettingCorrectPropertyFromCorrectFileTest() throws PropertiesReadingException {
        final String CORRECT_FILE = "gradle.properties";
        final String CORRECT_PROPERTY = "testBrowser";
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(CORRECT_FILE);
        String actual = propertiesFileReader.getProperty(CORRECT_PROPERTY);
        Assert.assertNotNull(actual);
    }

    /**
     * Test to get incorrect property from a correct file.
     * @throws PropertiesReadingException
     */
    @Test(expectedExceptions = PropertiesReadingException.class,
            expectedExceptionsMessageRegExp = "Error getting property: badProp")
    public void gettingInCorrectPropertyFromCorrectFileTest() throws PropertiesReadingException {
        final String CORRECT_FILE = "gradle.properties";
        final String CORRECT_PROPERTY = "badProp";
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(CORRECT_FILE);
        String actual = propertiesFileReader.getProperty(CORRECT_PROPERTY);
    }
}
