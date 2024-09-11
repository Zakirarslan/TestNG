package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage {
    /*
    1. Create constructor and use PageFactory class in to initiliase the page objects.
    2. Locate the webelemnts usin >FindBy annotation so we can call them in Test Class
    3. Traditional way/JUnit way---> Webelement username=driver.findelement(By.id(""));
       In TestNG ==>
     */
    public OrangeHRM_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (name="username")
    public WebElement username;

    @FindBy (name="password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;


    public void login(String userId, String pass){
        username.sendKeys(userId);
        password.sendKeys(pass);
        loginButton.click();

    }

}
