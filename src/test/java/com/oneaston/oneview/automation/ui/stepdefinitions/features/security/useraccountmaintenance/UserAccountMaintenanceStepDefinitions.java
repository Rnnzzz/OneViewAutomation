package com.oneaston.oneview.automation.ui.stepdefinitions.features.security.useraccountmaintenance;

import com.oneaston.oneview.automation.ui.dataprovider.content.OVContent;
import com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance.UserAccountMaintenancePage;
import com.oneaston.oneview.automation.ui.utils.assertions.AssertionUtility;
import com.oneaston.oneview.automation.ui.utils.dataprovider.DataProvider;
import com.oneaston.oneview.automation.ui.utils.dbutil.DBUtil;
import com.oneaston.oneview.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.Map;

public class UserAccountMaintenanceStepDefinitions {

    UserAccountMaintenancePage userAccountMaintenancePage = PageFactory.initElements(WebDriverFactory.getDriver(), UserAccountMaintenancePage.class);
    Map<String, String> testData;

    @Given("I clean-up user account data in the data-base")
    public void iCleanUpUserAccountDataInTheDatabase() {
        try {
            DBUtil dbUtil = new DBUtil();
            System.out.println("Removing user account data in the database...");
            System.out.println(dbUtil.deleteQuery("delete from usr_lvl_srp where user_account_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_password_history where user_account_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_notification where user_acct_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_login where user_account_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_data_access_jn where user_account_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_account_changelog where reference_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println(dbUtil.deleteQuery("delete from user_account where user_acct_id in (select user_acct_id from user_account where user_acct_code like 'at_%')"));
            System.out.println("User Account related data removed.");
        } catch (SQLException e) {
            Assert.fail("Error in cleaning up the data - " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("I should be able to see User Account Maintenance page details")
    public void iShouldBeAbleToSeeUserAccountMaintenancePageDetails() {
        AssertionUtility.assertTrue(userAccountMaintenancePage.getCurrentUrl().contains("userMaintenance"), "Error in navigating to User Account Maintenance page.");
    }

    @When("I enable created user")
    public void iEnterEnableCreatedUser() {
        userAccountMaintenancePage.search(testData.get("user_code")).changeUserState();
    }

    @And("I create a new user {string}")
    public void iCreateANewUser(String userCode) {
        testData = DataProvider.getTestData(userCode);
        userAccountMaintenancePage.clickCreateButton().inputDetails(testData.get("user_code"), testData.get("username"), testData.get("email"),
                testData.get("role"), testData.get("pf_number"), testData.get("contact"));
    }

    @Then("I should be able to see new user in the user table")
    public void iShouldBeAbleToSeeNewUserInTheUserTable() {
        OVContent userDetails = userAccountMaintenancePage.getUserAccountDetails(testData.get("user_code"));
        AssertionUtility.assertTextEquals(userDetails.getContent("code"), testData.get("user_code"));
    }

    @Then("User status should be enabled")
    public void userStatusShouldBeEnabled() {
        OVContent userDetails = userAccountMaintenancePage.getUserAccountDetails(testData.get("user_code"));
        AssertionUtility.assertTextEquals(userDetails.getContent("state"), "Disable");
    }

    @When("I delete user {string}")
    public void iDeleteUser(String userCode) {
        userAccountMaintenancePage.search(userCode).clickDeleteButton().search(userCode);
    }

    @Then("user details should not be visible in the user table")
    public void userDetailsShouldNotBeVisibleInTheUserTable() {
        OVContent userDetails = userAccountMaintenancePage.getUserAccountDetails(testData.get("user_code"));
        AssertionUtility.assertTextEquals(userDetails.getContent("code"), "");
    }
}
