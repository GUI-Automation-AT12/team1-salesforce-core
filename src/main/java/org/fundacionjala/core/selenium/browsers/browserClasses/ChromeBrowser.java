package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * [MR] Class of Browser that returns a ChromeDriver as WebDriver.
 */
public class ChromeBrowser implements IBrowser {

    /**
     * Initializes Chrome driver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version(
                BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_CHROME).getVersion()).setup();
        return new ChromeDriver();
    }
}
