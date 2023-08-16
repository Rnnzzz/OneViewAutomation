package com.oneaston.oneview.automation.ui.features.login;

import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.features.dashboard.DashboardPage;
import com.oneaston.oneview.automation.ui.seleniumutils.FindElement;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.TypeInteraction;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    final TypeInteraction typeInteraction;
    final ClickInteraction clickInteraction;
    final WaitMechanism waitMechanism;
    final FindElement findElement;

    public LoginPage(WebDriver driver) {
        super(driver);
        typeInteraction = new TypeInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
        waitMechanism = new WaitMechanism(driver);
        findElement = new FindElement(driver);
    }

    public DashboardPage login(String usercode, String password) {
        typeInteraction.type("j_username", usercode);
        typeInteraction.type("j_password", password);
        clickInteraction.clickElement("proceed");
        waitMechanism.waitUntilPageLoadIsComplete();
        return new DashboardPage(driver);
    }

    public String getErrorMessage() {
        waitMechanism.waitUntilPageLoadIsComplete();
        return findElement.findElement("//h3[contains(text(), 'Invalid')]").getText();
    }

}
