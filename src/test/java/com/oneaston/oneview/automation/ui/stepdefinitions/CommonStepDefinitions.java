package com.oneaston.oneview.automation.ui.stepdefinitions;

import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.utils.dataprovider.TestProperties;
import com.oneaston.oneview.automation.ui.utils.dbutil.DBUtil;
import com.oneaston.oneview.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class CommonStepDefinitions {

    protected TestProperties testProperties;
    BasePage basePage = new BasePage(WebDriverFactory.getDriver());

    public CommonStepDefinitions() {
        testProperties = TestProperties.getInstance();
    }

    @Given("I login as Admin user")
    public void iLoginAsAdminUser() {
        basePage.openPage(System.getProperty("ov_url")).login(testProperties.getProperty("admin_user"), testProperties.getProperty("admin_pass"));
    }

    @When("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        basePage.navigateToPage(page);
    }


}
