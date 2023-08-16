package com.oneaston.oneview.automation.ui.features.components;

import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.features.components.leftmenu.SecurityMenu;
import com.oneaston.oneview.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import org.openqa.selenium.WebDriver;

public class LeftMenu extends BasePage {

    private final ClickInteraction clickInteraction;
    private final WaitMechanism waitMechanism;

    public LeftMenu(WebDriver driver) {
        super(driver);
        clickInteraction = new ClickInteraction(driver);
        waitMechanism = new WaitMechanism(driver);
    }

    //
//    public Monitoring clickMonitoring() {
//        clickInteraction.clickElement( "c_monitoring");
//        return new Monitoring(driver);
//    }
//
//    public CreditParameters clickCreditParameters() {
//        clickInteraction.clickElement(5, "c_credit_parameters");
//        return new CreditParameters(driver, logger);
//    }
//
//    public ReportsPage clickReports() {
//        clickInteraction.clickElement(5, "i_reports");
//        return new ReportsPage(driver, logger);
//    }
//
    public SecurityMenu clickSecurityMenu() {
        clickInteraction.clickElement("c_security");
        return new SecurityMenu(driver);
    }
//
//    public DataAdministration clickDataAdministration() {
//        clickInteraction.clickElement(5, "c_data_administration");
//        waitMechanism.waitUntilPageLoadIsComplete();
//        return new DataAdministration(driver, logger);
//    }
//
//    public Libraries clickLibraries() {
//        clickInteraction.clickElement(5, "c_libraries");
//        waitMechanism.waitUntilPageLoadIsComplete();
//        return new Libraries(driver, logger);
//    }

//    public Simulation clickSimulation() {
//        clickInteraction.clickElement(5, "c_simulation");
//        waitMechanism.waitUntilPageLoadIsComplete();
//        return new Simulation(driver, logger);
//    }

//    public ErrorLogsPage clickErrorLogs() {
//        clickInteraction.clickElement(5, "i_errorlogs");
//        return new ErrorLogsPage(driver, logger);
//    }


}
