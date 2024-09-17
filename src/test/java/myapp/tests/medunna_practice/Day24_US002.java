package myapp.tests.medunna_practice;

import myapp.pages.Medunna_HomePage;
import myapp.pages.Medunna_RegistrationPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day24_US002 {
    /*
    US002: Registration should be successful using email and username
    US002AC01: Choose a username that can contain any chars, but it cannot be blank
        US002AC01TC01: User leaves the username blank, there should be "Your username is required." error message
        US002AC01TC02: User enters username special chars(£#$€), there should be "Your username is invalid." error message
        US002AC01TC03: User enters username  that can contain any chars, there should not be any error message

    US002AC02: email id cannot be created without "@" sign and "." extension
        US002AC02TC01: User enters the email as "johndoe.com", there should be "This field is invalid" error message
        US002AC02TC02: User enters the email as "john@doecom", there should be "This field is invalid" error message
        US002AC02TC03: User enters the email as "john@doe.", there should be "This field is invalid" error message
        US002AC02TC04: User enters the email as "@doe.com", there should be "This field is invalid" error message
        US002AC02TC05: User enters the email as "john@doe.com", there should not be any error message
    US002AC03: email cannot be left blank
        US002AC03TC01: User leaves the email blank, there should be "Your email is required." error message
        US002AC03TC02: User enters the email as "john@doe.com", there should not be any error message
        */
    Medunna_HomePage medunna_homePage = new Medunna_HomePage();
    Medunna_RegistrationPage medunnaRegistrationPage = new Medunna_RegistrationPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        BrowserUtils.clickWithTimeOut(medunna_homePage.accountMenu, 1);
        BrowserUtils.clickWithTimeOut(medunna_homePage.registerOption, 1);
    }
    // @AfterClass
    // public void closeDriver(){
    //     Driver.closeDriver();
    // }

    // Choose a username that can contain any chars, but it cannot be blank
    @Test
    public void medunna1() {
        // User leaves the username blank, there should be "Your username is required." error message
        medunnaRegistrationPage.username.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.userNameRequiredMessage);

        // User enters username special chars(£#$€), there should be "Your username is invalid." error message

        medunnaRegistrationPage.username.sendKeys("£#$€", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.userNameInvalidMessage);

        // User enters username  that can contain any chars, there should not be any error message
        medunnaRegistrationPage.username.clear();
        medunnaRegistrationPage.username.sendKeys("Techpro", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.userNameInvalidMessage);
    }

    // email id cannot be created without "@" sign and "." extension
    @Test
    public void medunna2() {
        // User enters the email as "johndoe.com", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.sendKeys("johndoe.com", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(1);

        // User enters the email as "john@doecom", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doecom", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);

        // User enters the email as "john@doe.", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doe.", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);

        // User enters the email as "@doe.com", there should be "This field is invalid" error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("@doe.com", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailInvalidMessage);

        // User enters the email as "john@doe.com", there should not be any error message
        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("john@doe.com", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.emailInvalidMessage);
        WaitUtils.waitFor(2);

    }

    //email cannot be left blank
    @Test
    public void medunna3() {
        // User leaves the email blank, there should be "Your email is required." error message


        medunnaRegistrationPage.email.clear();
        medunnaRegistrationPage.email.sendKeys("", Keys.ENTER);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.emailRequiredMessage);

        // User enters the email as "john@doe.com", there should not be any error message
        medunnaRegistrationPage.email.sendKeys("john@doe.com", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.emailInvalidMessage);


    }
}


















