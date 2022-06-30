package pages;

import org.openqa.selenium.WebDriver;
import support.WebSupport;

public class Results {

    WebSupport webSupport;

    public Results(WebDriver driver) {
        webSupport = new WebSupport(driver);
    }


    public void selectProduct(String product) {
        String moreInfoButton = "(//*[text() = '" + product + "']/following::button)[1]";
        webSupport.click(moreInfoButton);
    }
}
