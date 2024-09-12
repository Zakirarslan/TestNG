package myapp.tests.homework;

import myapp.pages.BlueRental_Homepage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class US3_Bad_Credential {
    /* User should see error message when user tries to login with incorrect credentials*/

    //Given user is on the application home page https://www.bluerentalcars.com/
    //Then clicks on login link
    //Then enters email=bluerental_email, password=bluerental_fakePassword
    //Then click on login button
    //Then verify the badCredentialsMessage is enable

    @Test
    public void badCredentialTest(){
        //Given user is on the application home page https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

        //Then clicks on login link
        BlueRental_Homepage blueRentalHomepage = new BlueRental_Homepage();
        BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
        BrowserUtils.clickWithTimeOut(blueRentalHomepage.userIcon,1);

        //Then enters email=bluerental_email, password=bluerental_fakePassword
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email,ConfigReader.getProperty("bluerental_email"),1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password,ConfigReader.getProperty("bluerental_fakePassword"),1);

        //Then click on login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        //Then verify the badCredentialsMessage is enable
        BrowserUtils.verifyElementClickable(blueRentalLoginPage.badCredentialsMessage);

        // Close driver
        Driver.closeDriver();



    }

}
