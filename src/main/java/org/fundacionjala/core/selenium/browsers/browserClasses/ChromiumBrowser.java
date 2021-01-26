package org.fundacionjala.core.selenium.browsers.browserClasses;

import io.github.bonigarcia.wdm.ChromiumDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;

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
        Browser browser = BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_CHROMIUM);
        ChromiumDriverManager.getInstance(CHROMIUM).version(browser.getVersion()).setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/tmp/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(browser.getFlags());
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }
}
