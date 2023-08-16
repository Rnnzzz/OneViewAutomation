package com.oneaston.oneview.automation.ui.features.components.leftmenu;

import com.oneaston.oneview.automation.ui.features.BasePage;
import com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance.UserAccountMaintenancePage;
import com.oneaston.oneview.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import org.openqa.selenium.WebDriver;

public class SecurityMenu extends BasePage {
    private final ClickInteraction clickInteraction;

    public SecurityMenu(WebDriver driver) {
        super(driver);
        clickInteraction = new ClickInteraction(driver);
    }

    public UserAccountMaintenancePage clickUserAccountMaintenance() {
        clickInteraction.clickElement("i_security_user_maintenance");
        return new UserAccountMaintenancePage(driver);
    }

//    public RoleMaintenancePage clickRoleMaintenance() {
//        clickInteraction.clickElement(5, "i_security_system_role_maintenance");
//        return new RoleMaintenancePage(driver, logger);
//    }

//    public BranchScreenPage clickBranchScreen() {
//        clickInteraction.clickElement(5, "i_security_branch_screen");
//        return new BranchScreenPage(driver, logger);
//    }

//    public ReportMaintenancePage clickReportMaintenance() {
//        clickInteraction.clickElement(5, "i_security_report_maintenance");
//        return new ReportMaintenancePage(driver, logger);
//    }

//    public DataAccessPage clickDataAccess() {
//        clickInteraction.clickElement(5, "i_data_access");
//        return new DataAccessPage(driver, logger);
//    }

//    public DataAccessGroupPage clickDataAccessGroup() {
//        clickInteraction.clickElement(5, "i_dataaccessgroup_maintenance");
//        return new DataAccessGroupPage(driver, logger);
//    }

//    public DataAccessListPage clickDataAccessList() {
//        clickInteraction.clickElement(5, "i_dataaccesslist");
//        return new DataAccessListPage(driver, logger);
//    }

}
