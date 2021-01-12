package org.fundacionjala.core.utils;

import org.fundacionjala.core.constans.ConstantsCore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonReaderTest {

    /**
     * Test to get essentials browser configurations from a json file.
     */
    @Test
    public void getBrowserVersionIsNotEmpty() {
        Map<String, Map<String, String>> jsonMap = JsonReader.getJsonAsMap("config/BrowserProperties.json");
        List<String> jsonElement = Arrays.asList(
                ConstantsCore.BROWSER_VERSION,
                ConstantsCore.BROWSER_IMPLICITWAIT,
                ConstantsCore.BROWSER_EXPLICITWAIT,
                ConstantsCore.BROWSER_SLEEPINGTIME
                );

        String message = "The field '%s' can not be empty.";
        Map<String, String> actual = jsonMap.get(ConstantsCore.BROWSER_CHROME);
        SoftAssert softAssertion = new SoftAssert();
        for (String element : jsonElement) {
            softAssertion.assertFalse(actual.get(element).isEmpty(), String.format(message, element));
        }
        softAssertion.assertAll();
    }
}
