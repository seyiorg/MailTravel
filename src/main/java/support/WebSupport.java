package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

public class WebSupport {
    public WebSupport(WebDriver driver) {
        this.driver=driver;
    }

    WebDriver driver;
    Logger log = LoggerFactory.getLogger(WebSupport.class);
    public void gotoPage(String pageURL) throws IOException {
        driver.get(pageURL);
    }

    public WebElement getElement(String element){
        return driver.findElement(By.xpath(element));
    }

    public List<WebElement> getElements(String element){
        return driver.findElements(By.xpath(element));
    }

    public void enterText(String element, String text){
        getElement(element).sendKeys(text);
    }

    public void click(String element){
        getElement(element).click();
    }

}
