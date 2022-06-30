package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import support.WebSupport;

@Data
public class BookingSummary {
    WebSupport webSupport;
    int costPerPerson = 1499;
    String totalBookingAmount = String.valueOf(costPerPerson * 2);
    String actualDisplayedBookingAmount;
    String displayedAmountSelector = "//*[text() = 'Total:']/following::span[1]";

    public BookingSummary(WebDriver driver) {
        webSupport = new WebSupport(driver);
    }

    public String getActualDisplayedAmount(){
        return actualDisplayedBookingAmount = webSupport.getElement(displayedAmountSelector)
                .getText().replaceAll("\\D", "");
    }
}
