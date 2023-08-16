package com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance;

import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.GetInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.SelectInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.TypeInteraction;
import org.openqa.selenium.WebDriver;

public class UserAccountMaintenanceConfigPage extends BasePage {

    public final GetInteraction getInteraction;
    private final TypeInteraction typeInteraction;
    private final ClickInteraction clickInteraction;
    private final SelectInteraction selectInteraction;
    private final WaitMechanism waitMechanism;

    public UserAccountMaintenanceConfigPage(WebDriver driver) {
        super(driver);
        typeInteraction = new TypeInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
        selectInteraction = new SelectInteraction(driver);
        getInteraction = new GetInteraction(driver);
        waitMechanism = new WaitMechanism(driver);
    }

    public UserAccountMaintenancePage inputDetails(String code, String username, String email, String role, String pfNumber, String contact) {
//        try {
        typeInteraction.type("userCode", code);
        typeInteraction.type("username", username);
        typeInteraction.type("email", email);
        typeInteraction.type("pfNumber", pfNumber);
        typeInteraction.type("primaryContact", contact);
        selectInteraction.selectElementByText("userRole", role.toUpperCase());
        clickInteraction.clickElement("btnSave");
        waitMechanism.waitFor(1000);
        waitMechanism.waitUntilPageLoadIsComplete();
        return new UserAccountMaintenancePage(driver);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver,  "Error inputting details " + e.getMessage());
//            return null;
//        }
    }

    public UserAccountMaintenancePage inputDetails(String username, String email, String role) {
//        try {
        typeInteraction.type("username", username);
        typeInteraction.type("email", email);
        selectInteraction.selectElementByText("userRole", role.toUpperCase());
        clickInteraction.clickElement("btnSave");
        waitMechanism.waitUntilPageLoadIsComplete();
        clickInteraction.clickElement("//button[contains(@class, 'btnBackToProfileLevel')]");
        return new UserAccountMaintenancePage(driver);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error inputting details " + e.getMessage());
//            return null;
//        }
    }
}
