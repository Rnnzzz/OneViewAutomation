package com.oneaston.oneview.automation.ui.features;

import com.oneaston.oneview.automation.ui.constants.PageEnum;
import com.oneaston.oneview.automation.ui.features.components.LeftMenu;
import com.oneaston.oneview.automation.ui.features.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        return new LoginPage(driver);
    }

    public void navigateToPage(String pageName) {
        PageEnum page = PageEnum.valueOf(pageName.toUpperCase().replace(" ", ""));

        switch (page) {
            case USERACCOUNTMAINTENANCE:
                openLeftMenu().clickSecurityMenu().clickUserAccountMaintenance();
            case ROLEMAINTENANCE:
                System.out.println("Open Role Maintanance");
                break;
            default:
                Assert.fail("No Page Identified for " + pageName);
                break;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public LeftMenu openLeftMenu() {
        return new LeftMenu(driver);
    }
}
