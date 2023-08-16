//package com.oneaston.oneview.automation.ui.pages.components.leftmenu;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.oneaston.oneview.testsuite.commons.actions.ClickActions;
//import com.oneaston.oneview.testsuite.feature.base.BasePage;
//import com.oneaston.oneview.testsuite.feature.libraries.functions.FunctionsPage;
//import com.oneaston.oneview.testsuite.feature.libraries.profiletemplates.ProfileTemplatesPage;
//import com.oneaston.oneview.testsuite.feature.libraries.rules.RulesPage;
//import org.openqa.selenium.WebDriver;
//
//public class Libraries extends BasePage {
//
//    private final ClickActions clickActions;
//
//    public Libraries(WebDriver driver, ExtentTest logger) {
//        super(driver, logger);
//        clickActions = new ClickActions(driver, logger);
//    }
//
//    public ProfileTemplatesPage clickProfileTemplates() {
//        clickActions.clickElement(5, "i_profile_templates");
//        return new ProfileTemplatesPage(driver, logger);
//    }
//
//    public RulesPage clickRules() {
//        clickActions.clickElement(5, "i_template_rules");
//        return new RulesPage(driver, logger);
//    }
//
//    public FunctionsPage clickFunctions() {
//        clickActions.clickElement(5, "i_functions");
//        return new FunctionsPage(driver, logger);
//    }
//}
