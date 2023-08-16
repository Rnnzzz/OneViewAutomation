package com.oneaston.oneview.automation.ui.constants;

public enum PageEnum {
    USERACCOUNTMAINTENANCE ("UserAccountMaintenancePage"),
    ROLEMAINTENANCE("RoleMaintenancePage");
    // Add more pages here


    private final String pageName;

    PageEnum(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }
}
