package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * [MR] Class of Browser that returns a FirefoxDriver as WebDriver.
 */
public class FirefoxBrowser implements IBrowser {

    /**
     * Initializes Firefox driver.
     */
    @Override
    public WebDriver initDriver() {
        Browser browser = BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_MOZILLA);
        FirefoxDriverManager.getInstance(FIREFOX).version(browser.getVersion()).setup();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", System.getProperty("user.dir") + "/src/test/resources/tmp/");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(browser.getFlags());
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }
}
