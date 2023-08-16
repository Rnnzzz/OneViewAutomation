package com.oneaston.oneview.automation.ui.seleniumutils.webinteractions;

import com.oneaston.oneview.automation.ui.seleniumutils.FindElement;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickInteraction {

    final FindElement findElement;
    final WaitMechanism waitMechanism;

    public ClickInteraction(WebDriver driver) {
        findElement = new FindElement(driver);
        waitMechanism = new WaitMechanism(driver);
    }

    /**
     * Click element by providing locator as parameter
     *
     * @param locator String
     */
    public void clickElement(String locator) {
        waitMechanism.waitUntilPageLoadIsComplete();
        WebElement element = findElement.findElement(locator);
        element.click();
    }
}
