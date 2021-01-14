package org.fundacionjala.core.utils;

import org.fundacionjala.core.config.TestExecutionProperties;
import org.fundacionjala.core.selenium.interaction.WebDriverManager;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * [SL] This class contains utilities methods that are useful for gui-core-salesforce project.
 */
public final class Utilities {
    /**
     * Takes a screenshot.
     * @param fName name of the file.
     * @throws PropertiesReadingException
     */
    public static void takeScreenShot(final String fName) throws PropertiesReadingException {
        String filePath = TestExecutionProperties.getInstance().getScreenShootStore();
        String fileName = fName.concat(".png");
        WebDriver driver = WebDriverManager.getInstance().getWebDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(filePath + fileName);
        srcFile.renameTo(targetFile);
    }
}
