package myapp.tests.homework;

import myapp.pages.BlueRental_Homepage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class US5_UnsuccessCarBook {

    @Test
            public void unsuccessCarBook() {

        //Given user is on the application home page https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));

        //Then select car from dropdown
        BlueRental_Homepage blueRentalHomepage = new BlueRental_Homepage();
        BrowserUtils.dropdownSelectByVisibleText(blueRentalHomepage.selectCarDropdown,"Ford Fiesta");










    }
}
