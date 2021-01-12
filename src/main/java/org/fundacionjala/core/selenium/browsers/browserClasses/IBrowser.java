package org.fundacionjala.core.selenium.browsers.browserClasses;

import org.openqa.selenium.WebDriver;

/**
 * [MR] Interface from all Browser Classes should implement with initDriver() method.
 */
public interface IBrowser {

    /**
     * Initializes a new webDriver for browser.
     * @return WebDriver
     */
    WebDriver initDriver();
}
