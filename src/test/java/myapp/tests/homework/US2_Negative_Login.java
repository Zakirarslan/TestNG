package myapp.tests.homework;

import myapp.pages.BlueRental_Homepage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class US2_Negative_Login {
    //Given user is on the application home page https://www.bluerentalcars.com/
    //Then clicks on login link
    //Then enters email="fake@bluerentalcars.com", password="fakepass"
    //Then click on login button
    //Then verify the login is unsuccessful

    @Test
    public void bluerentalCarNegativeTest() throws InterruptedException {
        //Given user is on the application home page https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

        //Then clicks on login link
        BlueRental_Homepage blueRentalHomepage = new BlueRental_Homepage();
        BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.userIcon,1);

        //Then enters email="fake@bluerentalcars.com", password="fakepass"
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email,ConfigReader.getProperty("bluerental_fakeEmail"),1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password,ConfigReader.getProperty("bluerental_fakePassword"),1);

        //Then click on login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        //Then verify the 'User with email fake@bluerentalcars.com not found' is displayed

       // Assert.assertTrue(blueRentalLoginPage.unsuccessfullogin.isEnabled());

        BrowserUtils.verifyElementClickable(blueRentalLoginPage.unsuccessfullogin);

        Driver.closeDriver();

       // BrowserUtils.verifyElementDisplayed(blueRentalLoginPage.unsuccessfullogin);






    }

}
