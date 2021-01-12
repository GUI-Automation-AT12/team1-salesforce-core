package org.fundacionjala.core.utils;

import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * [MR] This class contains tests for PropertiesFileReader main class.
 */
public class PropertiesFileReaderTest {

    private static final String CORRECT_FILE = "gradle.properties";
    private static final String INCORRECT_FILE = "gradle.prop";
    private static final String CORRECT_PROPERTY = "testBrowser";
    private static final String INCORRECT_PROPERTY = "badProp";

    /**
     * Test PropertiesFileReader correct Instantiation with correct file.
     * @throws PropertiesReadingException
     */
    @Test
    public void propertiesFileReaderInstantiationWithCorrectFileTest() throws PropertiesReadingException {
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
        new PropertiesFileReader(INCORRECT_FILE);
    }

    /**
     * Test to get correct property from a correct file.
     * @throws PropertiesReadingException
     */
    @Test
    public void gettingCorrectPropertyFromCorrectFileTest() throws PropertiesReadingException {
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
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader(CORRECT_FILE);
        propertiesFileReader.getProperty(INCORRECT_PROPERTY);
    }
}
