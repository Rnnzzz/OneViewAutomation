//package com.oneaston.oneview.automation.ui.pages.components.leftmenu;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.oneaston.oneview.testsuite.commons.actions.ClickActions;
//import com.oneaston.oneview.testsuite.feature.base.BasePage;
//import com.oneaston.oneview.testsuite.feature.simulation.portfoliosimulation.PortfolioSimulationPage;
//import com.oneaston.oneview.testsuite.feature.simulation.stresstest.StressTestPage;
//import org.openqa.selenium.WebDriver;
//
//public class Simulation extends BasePage {
//
//    private final ClickActions clickActions;
//
//    public Simulation(WebDriver driver, ExtentTest logger) {
//        super(driver, logger);
//        clickActions = new ClickActions(driver, logger);
//    }
//
//    public StressTestPage clickStressTest() {
//        clickActions.clickElement(5, "i_stress_test");
//        return new StressTestPage(driver, logger);
//    }
//
//    public PortfolioSimulationPage clickPortfolioSimulation() {
//        clickActions.clickElement(5, "i_portfolio_simulation");
//        return new PortfolioSimulationPage(driver, logger);
//    }
//
//}
