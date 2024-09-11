package myapp.tests.topics;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_CofigReaderTest {
    // Go to amazon page
// Verify the title includes amazon
// Check if Driver class is working

    @Test
    public void driverTest() throws InterruptedException {
        // driver.get("https://www.amazon.com/"); //we were calling driver from TestBase class in Junit framework


        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh(); // to get rid of captcha
        Thread.sleep(2000);
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains(ConfigReader.getProperty("amazon_title")));

        Driver.closeDriver();
    }
}
