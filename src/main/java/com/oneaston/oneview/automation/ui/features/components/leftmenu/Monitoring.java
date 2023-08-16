//package com.oneaston.oneview.automation.ui.pages.components.leftmenu;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.oneaston.oneview.testsuite.commons.actions.ClickActions;
//import com.oneaston.oneview.testsuite.commons.utils.loggerutil.AssertionUtil;
//import com.oneaston.oneview.testsuite.feature.base.BasePage;
//import com.oneaston.oneview.testsuite.feature.monitoring.creditactivity.CreditActivityPage;
//import com.oneaston.oneview.testsuite.feature.monitoring.creditlimit.CreditLimitPage;
//import com.oneaston.oneview.testsuite.feature.monitoring.securityholdings.SecurityHoldingsPage;
//import org.openqa.selenium.WebDriver;
//
//public class Monitoring extends BasePage {
//
//    private final ClickActions clickActions;
//
//    public Monitoring(WebDriver driver, ExtentTest logger) {
//        super(driver, logger);
//        clickActions = new ClickActions(driver, logger);
//    }
//
//    public CreditActivityPage clickCreditActivity() {
//        try {
//            clickActions.clickElement(5, "i_credit_activity");
//            return new CreditActivityPage(driver, logger);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error in clicking element " + e.getMessage());
//            return null;
//        }
//    }
//
//    public CreditLimitPage clickCreditLimit() {
//        try {
//            clickActions.clickElement(5, "i_credit_limit");
//            return new CreditLimitPage(driver, logger);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error in clicking element " + e.getMessage());
//            return null;
//        }
//    }
//
//    public SecurityHoldingsPage clickSecurityHoldings() {
//        try {
//            clickActions.clickElement(5, "i_security_holdings");
//            return new SecurityHoldingsPage(driver, logger);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error in clicking element " + e.getMessage());
//            return null;
//        }
//    }
//
//}
