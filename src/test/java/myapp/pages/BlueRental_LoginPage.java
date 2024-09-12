package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_LoginPage {


    // 1. Create constructor and initiate PageFactory
    // 2 . Locate and store webElements



    public BlueRental_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//div[contains(text(),'User with email fake@bluerentalcars.com not found')]")
    public WebElement unsuccessfullogin;

    @FindBy (xpath ="//div[contains(text(), 'Bad credentials')]")
    public WebElement badCredentialsMessage;

    @FindBy (xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement EmailErrorMessage;


}
