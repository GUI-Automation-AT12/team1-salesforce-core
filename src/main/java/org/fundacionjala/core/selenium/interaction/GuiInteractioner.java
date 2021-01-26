package org.fundacionjala.core.selenium.interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * [MR] Class that allows the WebDriver can interact with the GUI.
 */
public final class GuiInteractioner {

    private GuiInteractioner() {
    }

    private static WebElement findElementBy(final By by) {
        return WebDriverManager.getInstance().getWebDriver().findElement(by);
    }

    /**
     * Clears the previous text in a WebElement and fills a new text into it.
     *
     * @param webElement to set text
     * @param text       text to be set
     */
    public static void setInputText(final WebElement webElement, final String text) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Provide fillWebElement method to support By objects.
     *
     * @param by   element found to set text
     * @param text text to be set
     */
    public static void setInputText(final By by, final String text) {
        setInputText(findElementBy(by), text);
    }

    /**
     * Waits for a WebElement to be clickable and clicks it.
     *
     * @param webElement to be clicked
     */
    public static void clickWebElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Provide clickWebElement method to support By objects.
     *
     * @param by element found to be clicked
     */
    public static void clickWebElement(final By by) {
        clickWebElement(findElementBy(by));
    }

    /**
     * Scrolls down until find a WebElement.
     *
     * @param webElement to be found in the page
     */
    public static void scrollDownToFindElement(final WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    /**
     * Provide scrollDownToFindElement method supporting to find By elements.
     *
     * @param by to be found in the page
     */
    public static void scrollDownToFindElement(final By by) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", findElementBy(by));
    }

    /**
     * Searches for a WebElement and get the inner text.
     *
     * @param webElement to get text
     * @return String text from the WebElement.
     */
    public static String getTextFromWebElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Provide getTextFromWebElement method to support By objects.
     *
     * @param by element found to get text
     * @return String text from the By.
     */
    public static String getTextFromWebElement(final By by) {
        return getTextFromWebElement(findElementBy(by));
    }

    /**
     * Searches for an specific option in a list, then clicks it.
     *
     * @param webElementList list of elements
     * @param selected       ,text of the searched element to be clicked
     */
    public static void clickOptionFromWebElementList(final List<WebElement> webElementList, final String selected) {
        for (WebElement option : webElementList) {
            if (option.getText().contains(selected)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Searches for an specific option WebElement that contains a text.
     *
     * @param webElementList list of elements
     * @param text           of the searched element
     * @return WebElement if it can find it, otherwise return null
     */
    public static WebElement searchTextInWebElementList(final List<WebElement> webElementList, final String text) {
        for (WebElement element : webElementList) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Get the state of a Web Element.
     *
     * @param webElement to ask for its state
     * @return true if the WebElement is selected, otherwise return false
     */
    public static boolean getStateOfWebElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isSelected();
    }

    /**
     * Provide getStateOfWebElement method to support By objects.
     *
     * @param by element to ask for its state
     * @return true if the WebElement is selected, otherwise return false
     */
    public static boolean getStateOfWebElement(final By by) {
        return getStateOfWebElement(findElementBy(by));
    }

    /**
     * Gets the inner value of a specific attribute of a WebElement.
     *
     * @param webElement to get attribute's value
     * @param attribute  of the WebElement
     * @return a String with the value of the attribute, otherwise return null
     */
    public static String getAttributeOfWebElement(final WebElement webElement, final String attribute) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);
    }

    /**
     * Provide getAttributeOfWebElement method to support By objects.
     *
     * @param by        element to get attribute's value
     * @param attribute of the By element
     * @return a String with the value of the attribute, otherwise return null
     */
    public static String getAttributeOfWebElement(final By by, final String attribute) {
        return getAttributeOfWebElement(findElementBy(by), attribute);
    }

    /**
     * [SL] Change focus to the default content after in this new DOM.
     * find the iframe and wait to the render and change  to it.
     *
     * @param webElement of the an iframe
     */

    public static void frameToBeAvailableAndSwitchToIt(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriver().switchTo().defaultContent();
        WebDriverManager.getInstance().getWebDriverWait()
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }

    /**
     * [SL] Gets the value attribute from a WebElement.
     *
     * @param webElement of the WebElement
     * @return a String with the value attribute, otherwise return null
     */
    public static String getValueOfWebElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute("value");
    }

    /**
     * [SL] Gets the value attribute from a By.
     *
     * @param by of the by element
     * @return a String with the value attribute, otherwise return null
     */
    public static String getValueOfWebElement(final By by) {
        return getValueOfWebElement(findElementBy(by));
    }

    /**
     * [SL] Waits an webElement to be visible.
     *
     * @param webElement
     */
    public static void waitLoadPage(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * [SL] Sends the key down simulating a scroll.
     *
     * @param scroll
     */
    public static void loadDynamicTable(final By scroll) {
        WebDriverManager.getInstance().getWebDriver().findElement(scroll).sendKeys(Keys.PAGE_DOWN);
    }
}
