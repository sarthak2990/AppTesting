package testClasses;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testSteps.HomePageSteps;
import utilities.LogUtility;
import utilities.PropertyReader;

import java.util.Properties;

public class HomePageSmokeTest extends BaseClass {
    private LogUtility logger = new LogUtility(HomePageSmokeTest.class);
    private HomePageSteps homePageSteps;
    private Properties loginPageOptions = PropertyReader.readLocatorProperties("loginScreen.properties");

    /*
     * Creating Dataprovider for expenses and income
     * @return Object[] where first column contains 'expense/income' categories

     */

    @BeforeMethod
    public void intialize() {
        homePageSteps = new HomePageSteps(sessionManager);
    }

    @DataProvider(name = "ExpenseProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"house"},
                        {"bill"},
                        {"car"},
                        {"clothes"},
                        {"communications"},
                        {"eatingOut"},
                        {"entertainment"},
                        {"food"},
                        {"gifts"},
                        {"health"},
                        {"pets"},
                        {"sports"},
                        {"taxi"},
                        {"toiletry"},
                        {"transport"}
                };

    }

    @DataProvider(name = "IncomeProvider")
    public Object[][] getDataFromDataproviderIncome() {
        return new Object[][]
                {
                        {"salary"},
                        {"deposits"},
                        {"savings"}
                };

    }

    String expectedTestBalance = "$55.00";
    String totalBalanceText = "Balance $11.00";

    //Using data provider to run tests
    @Test(dataProvider = "ExpenseProvider")
    public void verifyExpenseAddForHouse(String category) {
        /**
         * In this we  will veridy positive expense*/
        Assert.assertEquals(homePageSteps.verifyExpense(category), expectedTestBalance);
    }

    @Test(dataProvider = "IncomeProvider")
    public void verifyIncomeAdd(String incomeCategry) {
        /**
         * In this we  will veridy positive salary*/
        Assert.assertEquals(homePageSteps.verifyIncome(incomeCategry), expectedTestBalance);
    }

    @Test
    public void verifyBalanceAmountWhenExpenseIncomeAdd() {
        Assert.assertEquals(homePageSteps.verifyBalance(), totalBalanceText);
    }

    @Test(dataProvider = "ExpenseProvider")
    public void verifySearchFunctionality(String categry) {
        Assert.assertEquals(homePageSteps.verifySearch(categry), expectedTestBalance);
    }

    @Test
    public void verifyRightMenuOptions() {
        Assert.assertTrue(homePageSteps.isRightMenuOptionsPresent());
    }

    @Test
    public void verifyLeftMenuOptions() {
        Assert.assertTrue(homePageSteps.isLeftMenuOptionsPresent());
    }


}
