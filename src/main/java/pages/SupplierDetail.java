package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import support.WebSupport;

@Data
public class SupplierDetail {

    WebSupport webSupport;
    String phoneNumberLocator = "//*[@id='supplier-phone']";
    String phoneNumber1 = "08082397366";
    String phoneNumber2 = "08082396459";
    String displayedPhoneNos;

    public SupplierDetail(WebDriver driver) {
        webSupport = new WebSupport(driver);
    }

    public String getDisplayedPhoneNos() {
        return this.displayedPhoneNos = webSupport.getElement(phoneNumberLocator).getText();
    }

    public void bookOnline() {
        String bookNowBtn = "(//*[text() = 'Book Online'])[1]";
        webSupport.getElement(bookNowBtn).click();
    }
}
