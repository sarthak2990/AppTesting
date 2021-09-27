package testSteps;

import library.AppiumLibrary;
import org.testng.Assert;
import sessions.SessionManager;
import testClasses.HomePageSmokeTest;
import utilities.LogUtility;
import utilities.PropertyReader;

import java.util.Properties;

public class HomePageSteps {

    private AppiumLibrary appiumLibrary;
    private Properties homeScreen = PropertyReader.readLocatorProperties("homeScreen.properties");
    private LogUtility logger = new LogUtility(HomePageSmokeTest.class);

    public HomePageSteps(SessionManager sessionManager) {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public String verifyExpense(String category) {
        appiumLibrary.click(homeScreen.getProperty("expense"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("choseCategry"));
        appiumLibrary.click(homeScreen.getProperty(category));
        return appiumLibrary.getText(homeScreen.getProperty("amountText"));
    }

    public String verifyIncome(String category) {
        appiumLibrary.click(homeScreen.getProperty("income"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("choseCategry"));
        appiumLibrary.click(homeScreen.getProperty(category));
        return appiumLibrary.getText(homeScreen.getProperty("incomeAmtText"));
    }

    public String verifyBalance() {
        logger.logInfo("Adding Expense");
        appiumLibrary.click(homeScreen.getProperty("income"));
        appiumLibrary.click(homeScreen.getProperty("keyboard6"));
        appiumLibrary.click(homeScreen.getProperty("keyboard6"));
        appiumLibrary.click(homeScreen.getProperty("choseCategry"));
        appiumLibrary.click(homeScreen.getProperty("salary"));
        appiumLibrary.click(homeScreen.getProperty("expense"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("amountTextBox"));
        appiumLibrary.click(homeScreen.getProperty("choseCategry"));
        appiumLibrary.click(homeScreen.getProperty("house"));
        return appiumLibrary.getText(homeScreen.getProperty("balanceAmount"));
    }

    public String verifySearch(String categry) {
        verifyExpense(categry);
        appiumLibrary.click(homeScreen.getProperty("search"));
        appiumLibrary.enterText(homeScreen.getProperty("searchTextBox"), categry);
        appiumLibrary.click(homeScreen.getProperty(categry));
        categry = capitalize(categry);
        Assert.assertEquals(appiumLibrary.getText(homeScreen.getProperty("searchTitle")), categry);
        return appiumLibrary.getText(homeScreen.getProperty("searchAmountView"));
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public boolean isRightMenuOptionsPresent() {
        boolean result = false;
        appiumLibrary.click(homeScreen.getProperty("rightMenu"));
        if (appiumLibrary.isElementPresent(homeScreen.getProperty("categories"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("accounts"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("currencies"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("settings"), 1)) {
            {
                result = true;
            }
        }
        return result;
    }

    public boolean isLeftMenuOptionsPresent() {
        boolean result = false;
        appiumLibrary.click(homeScreen.getProperty("leftMenu"));
        if (appiumLibrary.isElementPresent(homeScreen.getProperty("allAccounts"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("day"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("week"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("month"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("year"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("all"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("interval"), 1) && appiumLibrary.isElementPresent(homeScreen.getProperty("chooseDate"), 1)) {
            {
                result = true;
            }
        }
        return result;
    }
}
