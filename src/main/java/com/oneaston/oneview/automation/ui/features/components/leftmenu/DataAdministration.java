//package com.oneaston.oneview.automation.ui.pages.components.leftmenu;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.oneaston.oneview.testsuite.commons.actions.ClickActions;
//import com.oneaston.oneview.testsuite.feature.base.BasePage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.client.ClientPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.counterparties.CounterpartiesPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.exchangerate.ExchangeRatePage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.instrument.InstrumentPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.persons.PersonsPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.portfolio.PortfolioPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.staticdata.StaticDataPage;
//import com.oneaston.oneview.testsuite.feature.dataadministration.staticdata.SystemDataPage;
//import org.openqa.selenium.WebDriver;
//
//public class DataAdministration extends BasePage {
//    private final ClickActions clickActions;
//
//    public DataAdministration(WebDriver driver, ExtentTest logger) {
//        super(driver, logger);
//        clickActions = new ClickActions(driver, logger);
//    }
//
//    public ClientPage clickClient() {
//        clickActions.clickElement(5, "i_clients");
//        return new ClientPage(driver, logger);
//    }
//
//    public PersonsPage clickPersons() {
//        clickActions.clickElement(5, "i_persons");
//        return new PersonsPage(driver, logger);
//    }
//
//    public PortfolioPage clickPortfolio() {
//        clickActions.clickElement(5, "i_portfolios");
//        return new PortfolioPage(driver, logger);
//    }
//
//    public InstrumentPage clickInstrument() {
//        clickActions.clickElement(5, "i_instruments");
//        return new InstrumentPage(driver, logger);
//    }
//
//    public CounterpartiesPage clickCounterparties() {
//        clickActions.clickElement(5, "i_counterparties");
//        return new CounterpartiesPage(driver, logger);
//    }
//
//    public ExchangeRatePage clickExchangeRate() {
//        clickActions.clickElement(5, "i_exchange_rate");
//        return new ExchangeRatePage(driver, logger);
//    }
//
//    public StaticDataPage clickStaticData() {
//        clickActions.clickElement(5, "i_static_data");
//        return new StaticDataPage(driver, logger);
//    }
//
//    public SystemDataPage clickSystemData() {
//        clickActions.clickElement(5, "i_system_data");
//        return new SystemDataPage(driver, logger);
//    }
//
//}
