//package com.oneaston.oneview.automation.ui.pages.components.leftmenu;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.oneaston.oneview.testsuite.commons.actions.ClickActions;
//import com.oneaston.oneview.testsuite.feature.base.BasePage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.creditclassification.CreditClassificationPage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.drawinglimits.DrawingLimitsPage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.facilitydetails.FacilityDetailsPage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.indulgence.IndulgencePage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.lendingratio.LendingRatioPage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.meptrigger.MEPTriggerPage;
//import com.oneaston.oneview.testsuite.feature.creditparameters.pledge.PledgePage;
//import org.openqa.selenium.WebDriver;
//
//public class CreditParameters extends BasePage {
//
//    private final ClickActions clickActions;
//
//    public CreditParameters(WebDriver driver, ExtentTest logger) {
//        super(driver, logger);
//        clickActions = new ClickActions(driver, logger);
//    }
//
//    public LendingRatioPage clickLendingRatio() {
//        clickActions.clickElement(5, "i_lending_ratios");
//        return new LendingRatioPage(driver, logger);
//    }
//
//    public PledgePage clickPledge() {
//        clickActions.clickElement(5, "i_pledge");
//        return new PledgePage(driver, logger);
//    }
//
//    public FacilityDetailsPage clickFacilityDetails() {
//        clickActions.clickElement(5, "i_facility");
//        return new FacilityDetailsPage(driver, logger);
//    }
//
//    public CreditClassificationPage clickCreditClassification() {
//        clickActions.clickElement(5, "i_creditclassification");
//        return new CreditClassificationPage(driver, logger);
//    }
//
//    public MEPTriggerPage clickMEPTrigger() {
//        clickActions.clickElement(5, "i_meptrigger");
//        return new MEPTriggerPage(driver, logger);
//    }
//
//    public IndulgencePage clickIndulgence() {
//        clickActions.clickElement(5, "i_indulgence");
//        return new IndulgencePage(driver, logger);
//    }
//
//    public DrawingLimitsPage clickDrawingLimits() {
//        clickActions.clickElement(5, "i_drawingLimits");
//        return new DrawingLimitsPage(driver, logger);
//    }
//}
