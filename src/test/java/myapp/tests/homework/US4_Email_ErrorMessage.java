package myapp.tests.homework;

import myapp.pages.BlueRental_Homepage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class US4_Email_ErrorMessage {
    @Test
            public void emailErrorMessage() {

        //Given user is on the application home page https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

        //Then clicks on login link
        BlueRental_Homepage blueRentalHomepage = new BlueRental_Homepage();
        BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.userIcon, 1);

        //Then enters email=bluerental_email, password=bluerental_fakePassword
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_invalidEmail"), 1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 1);

        //Then click on login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        //Then verify 'email must be a valid email' is displayed
        BrowserUtils.verifyElementDisplayed(blueRentalLoginPage.EmailErrorMessage);







    }
}
