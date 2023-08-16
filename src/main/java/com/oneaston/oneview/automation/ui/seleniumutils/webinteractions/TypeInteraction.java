package com.oneaston.oneview.automation.ui.seleniumutils.webinteractions;

import com.oneaston.oneview.automation.ui.seleniumutils.FindElement;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypeInteraction {

    private final FindElement findElementClass;
    private final WaitMechanism waitActions;


    public TypeInteraction(WebDriver driver) {
        findElementClass = new FindElement(driver);
        waitActions = new WaitMechanism(driver);
    }

    /**
     * Type character sequence by providing locator as parameter
     *
     * @param locator String
     * @param text  String
     */
    public void type(String locator, CharSequence text) {
        waitActions.waitUntilPageLoadIsComplete();
        WebElement element = findElementClass.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}
