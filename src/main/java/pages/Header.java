package pages;

import org.openqa.selenium.WebDriver;
import support.WebSupport;

public class Header {

    WebSupport webSupport;
    String searchPanelLocator = "//input[@id='searchtext_freetext_search_form']";
    String searchBarIcon = "//input[@id='searchtext_freetext_search_form']/..//button";

    public Header(WebDriver driver) {
        webSupport = new WebSupport(driver);
    }

    public void travelSearch(String text) {
        webSupport.enterText(searchPanelLocator, text);
        webSupport.click(searchBarIcon);
    }
}
