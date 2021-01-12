package org.fundacionjala.core.selenium.browsers.browserClasses;

import io.github.bonigarcia.wdm.ChromiumDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static io.github.bonigarcia.wdm.DriverManagerType.CHROMIUM;

/**
 * [MR] Class of Browser that returns a Chromium Driver as WebDriver.
 */
public class ChromiumBrowser implements IBrowser {
    /**
     * Initializes Chromium driver.
     */
    @Override
    public WebDriver initDriver() {
        ChromiumDriverManager.getInstance(CHROMIUM).version(
                BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_CHROMIUM).getVersion()).setup();
        return new ChromeDriver();
    }
}
