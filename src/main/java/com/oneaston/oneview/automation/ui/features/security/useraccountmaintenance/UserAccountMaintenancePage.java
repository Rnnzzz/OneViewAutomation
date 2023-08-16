package com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance;

import com.oneaston.oneview.automation.ui.dataprovider.content.OVContent;
import com.oneaston.oneview.automation.ui.dataprovider.content.OVGroupContent;
import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance.model.UserAccount;
import com.oneaston.oneview.automation.ui.seleniumutils.FindElement;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.GetInteraction;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.TypeInteraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserAccountMaintenancePage extends BasePage {
    final GetInteraction getInteraction;
    final TypeInteraction typeInteraction;
    final ClickInteraction clickInteraction;
    final WaitMechanism waitMechanism;
    final FindElement findElement;
    String locatorUserTable = "userAccountsDataTable";

    public UserAccountMaintenancePage(WebDriver driver) {
        super(driver);
        typeInteraction = new TypeInteraction(driver);
        waitMechanism = new WaitMechanism(driver);
        getInteraction = new GetInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
        findElement = new FindElement(driver);
    }

    public UserAccountMaintenancePage clickExpiredUser() {
        clickInteraction.clickElement("//span[text()='Expired User']/parent::a");
        locatorUserTable = "userAccountsExpiredDataTable";
        return this;
    }

    public UserAccountMaintenancePage search(String text) {
        typeInteraction.type("input-10", text);
        waitMechanism.waitUntilPageLoadIsComplete();
        return this;
    }

    public OVContent getUserAccountDetails(String text) {
        waitMechanism.waitUntilPageLoadIsComplete();
        return search(text).getOVDataFromUi();
    }

    private String getTableData() {
        waitMechanism.waitUntilPageLoadIsComplete();
        return getInteraction.getElementAttribute("//table[@id='" + locatorUserTable + "']/tbody/tr[1]", "innerText");
    }

    private UserAccount getDetails() {
        String code, username, email, role, status, state;

        code = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[1]");
        username = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[2]/span[1]");
        email = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[2]/span[2]");
        role = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[3]/button/span");
        status = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[4]/div/span[2]");
        state = getInteraction.getElementText("//table[@id='" + locatorUserTable + "']/tbody/tr[1]/td[6]/button/span");
        return new UserAccount(code, username, email, role, status, state);
    }

    private UserAccount getDetails(WebElement element) {
        String code, username, email, role, status, state;

        code = getInteraction.getElementAttribute(findElement.findElement(element, "td[1]"), "innerText");
        username = getInteraction.getElementAttribute(findElement.findElement(element, "td[2]/span[1]"), "innerText");
        email = getInteraction.getElementAttribute(findElement.findElement(element, "td[2]/span[2]"), "innerText");
        role = getInteraction.getElementAttribute(findElement.findElement(element, "td[3]/button/span"), "innerText");
        status = getInteraction.getElementAttribute(findElement.findElement(element, "td[4]/div/span[2]"), "innerText");
        state = getInteraction.getElementAttribute(findElement.findElement(element, "td[6]/button/span"), "innerText");
        return new UserAccount(code, username, email, role, status, state);
    }

    public OVContent getOVDataFromUi() {
        OVContent content = new OVContent(UserAccount.defaultContent());
        if (!getTableData().equals("No data available in table")) {
            UserAccount details = getDetails();
            content.addContent("code", details.getCode());
            content.addContent("username", details.getUsername());
            content.addContent("email", details.getEmail());
            content.addContent("role", details.getRole());
            content.addContent("status", details.getStatus());
            content.addContent("state", details.getState());
        }
        return content;
    }

    public OVContent getOVDataFromUi(WebElement elementUserRow) {
        OVContent content = new OVContent(UserAccount.defaultContent());
        if (!getTableData().equals("No data available in table")) {
            UserAccount details = getDetails(elementUserRow);
            content.addContent("code", details.getCode());
            content.addContent("username", details.getUsername());
            content.addContent("email", details.getEmail());
            content.addContent("role", details.getRole());
            content.addContent("status", details.getStatus());
            content.addContent("state", details.getState());
        }
        return content;
    }

    private boolean hasNextPage() {
        boolean hasNextPage = !getInteraction.getElementAttribute(locatorUserTable + "_next", "class").contains("disabled");
        clickInteraction.clickElement("//li[@id='" + locatorUserTable + "_next']/a");
        waitMechanism.waitUntilPageLoadIsComplete();
        return hasNextPage;
    }

    public OVGroupContent listAll() {
        waitMechanism.waitUntilPageLoadIsComplete();
        OVGroupContent allUser = new OVGroupContent();
        do {
            List<WebElement> elementListUsers = findElement.findElements("//table[@id='" + locatorUserTable + "']/tbody/tr");
            getUsersFromList(allUser, elementListUsers);
        } while (hasNextPage());
        return allUser;
    }

    private void getUsersFromList(OVGroupContent allUser, List<WebElement> elementListUsers) {
        for (WebElement elementUserRow : elementListUsers) {
            OVContent user = getOVDataFromUi(elementUserRow);
            allUser.addContent(user.getContent("code"), user);
        }
    }

    public UserAccountMaintenanceConfigPage clickCreateButton() {
        clickInteraction.clickElement("btnCreateNew");
        return new UserAccountMaintenanceConfigPage(driver);
    }

    public UserAccountMaintenanceConfigPage clickEditButton() {
        waitMechanism.waitUntilPageLoadIsComplete();
        clickInteraction.clickElement("//table[@id='" + locatorUserTable + "']//tbody/tr[1]/td/button/span[text()='Edit']");
        return new UserAccountMaintenanceConfigPage(driver);
    }

    public UserAccountMaintenancePage clickDeleteButton() {
//        try {
        waitMechanism.waitUntilPageLoadIsComplete();
        clickInteraction.clickElement("//table[@id='" + locatorUserTable + "']//tbody/tr[1]/td/button/span[text()='Delete']");
        waitMechanism.waitFor(1000);
        clickInteraction.clickElement("//button[contains(@class, 'confirm')]");
        return this;
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error in deleting user account " + e.getMessage());
//            return null;
//        }
    }

    public UserAccountMaintenancePage changeUserState() {
        clickInteraction.clickElement("//table[@id='userAccountsDataTable']/tbody/tr[1]/td[6]/button");
        waitMechanism.waitFor(1000);
        clickInteraction.clickElement("//button[contains(@class, 'confirm')]");
        waitMechanism.waitUntilAlertMessageIsGone();
        waitMechanism.waitUntilPageLoadIsComplete();
        return this;
    }
}
