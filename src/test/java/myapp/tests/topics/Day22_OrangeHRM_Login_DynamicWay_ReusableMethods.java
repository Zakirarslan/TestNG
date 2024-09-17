package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class Day22_OrangeHRM_Login_DynamicWay_ReusableMethods {
    // Automate login functionality, using page object model
    // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    // Given user is the application login page
    // Then enter the credentials
    // Then verify the login is successful
    // And logout the application
    // Then verify the logout is successful
    @Test (groups = "minor_regression_group")
    public void loginTestDynamic_ReusableMethods(){

        // Given user is the application login page
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url"));

        // Then enter the credentials
        // Inorder to access the Webelements, we need to create Page Object.
        OrangeHRM_LoginPage orangeHRM_loginPage=new OrangeHRM_LoginPage();
        OrangeHRM_DashboardPage orangeHRM_dashboardPage=new OrangeHRM_DashboardPage();

        //Recommended way use reusable methods
        // Then enter the credentials
        BrowserUtils.sendKeysWithTimeout(orangeHRM_loginPage.username,ConfigReader.getProperty("orangeHRM_username"),1);
        BrowserUtils.sendKeysWithTimeout(orangeHRM_loginPage.password,ConfigReader.getProperty("orangeHRM_password"),1);
        BrowserUtils.clickWithTimeOut(orangeHRM_loginPage.loginButton,1);

        // Then verify the login is successful
        BrowserUtils.verifyElementDisplayed(orangeHRM_dashboardPage.dropdown);


        // And logout the application
        BrowserUtils.clickWithTimeOut(orangeHRM_dashboardPage.dropdown,1);
        BrowserUtils.clickWithTimeOut(orangeHRM_dashboardPage.logout,1);

        // Then verify the logout is successful
        BrowserUtils.verifyElementDisplayed(orangeHRM_loginPage.username);
        Driver.closeDriver();
    }


}
