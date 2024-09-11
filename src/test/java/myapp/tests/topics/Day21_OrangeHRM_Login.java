package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_OrangeHRM_Login {

   // Automate login functionality, using page object model
   // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
   // Given user is the application login page
   // Then enter the credentials
   // Then verify the login is successful
   // And logout the application
   // Then verify the logout is successful
    @Test
    public void loginTest(){

        // Given user is the application login page
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Then enter the credentials
        // Inorder to access the Webelements, we need to create Page Object.
     OrangeHRM_LoginPage orangeHRM_loginPage=new OrangeHRM_LoginPage();

     // orangeHRM_loginPage.username.sendKeys("Admin");
     // WaitUtils.waitFor(2);

     // orangeHRM_loginPage.password.sendKeys("admin123");
     // WaitUtils.waitFor(2);

     // orangeHRM_loginPage.loginButton.click();

        //Reusable method for PAGE SPECİFİC FUNCTİON
        orangeHRM_loginPage.login("Admin","admin123");

        // Then verify the login is successful
        OrangeHRM_DashboardPage orangeHRM_dashboardPage=new OrangeHRM_DashboardPage();
        Assert.assertTrue(orangeHRM_dashboardPage.dropdown.isDisplayed());

        // And logout the application
        orangeHRM_dashboardPage.dropdown.click();
        orangeHRM_dashboardPage.logout.click();

        // Then verify the logout is successful
        Assert.assertTrue(orangeHRM_loginPage.username.isDisplayed());
        Driver.closeDriver();


    }




}
