package pages;

import model.EmployeeBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.WebSupport;

public class BookingPage {

    WebSupport webSupport;
    String continueButtonSelector;
    EmployeeBuilder employee;
    SupplierDetail supplierDetail;
    WebDriverWait wait;

    public BookingPage(WebDriver driver) {
        webSupport = new WebSupport(driver);
        employee = new EmployeeBuilder();
        supplierDetail = new SupplierDetail(driver);
        wait = new WebDriverWait(driver, 5);
    }

    public void bookSupplier() {
        webSupport.click(continueButtonSelector);
        selectRoomType();
    }

    public void selectRoomType() {
        String roomType_double = "//*[text() = 'Double ']/following::select[1]";
        String selectRoomAndContinue = "//*[text() = 'Select your room and continue']";
        Select roomType = new Select(webSupport.getElement(roomType_double));
        roomType.selectByIndex(1);
        webSupport.click(selectRoomAndContinue);
    }

    public void fillDateDepartureForm() {
        String selectRoomAndContinue = "(//button[@type = 'submit'])[3]";
        webSupport.click(selectRoomAndContinue);
    }

    public void fillAccommodationForm() {
        selectRoomType();
    }

    public void fillExtrasForm() {
    }

    public void fillPassengerDetailsForm() {

        String adult1_title_selector = "(//*[text() = 'Title'])[1]/following::select[1]";
        String adult1_firstNameSelector = "//*[@id = 'pax-a-first-1']";
        String adult1_lastName_selector = "//*[@id = 'pax-a-last-1']";
        String adult1_DOB_day_selector = "(//*[text() = 'Date of Birth'])[1]/following::select[1]";
        String adult1_DOB_month_selector = "(//*[text() = 'Date of Birth'])[1]/following::select[2]";
        String adult1_DOB_year_selector = "(//*[text() = 'Date of Birth'])[1]/following::select[3]";

        String adult2_title_selector = "(//*[text() = 'Title'])[2]/following::select[1]";
        String adult2_firstNameSelector = "//*[@id = 'pax-a-first-2']";
        String adult2_lastName_selector = "//*[@id = 'pax-a-last-2']";
        String adult2_DOB_day_selector = "(//*[text() = 'Date of Birth'])[2]/following::select[1]";
        String adult2_DOB_month_selector = "(//*[text() = 'Date of Birth'])[2]/following::select[2]";
        String adult2_DOB_year_selector = "(//*[text() = 'Date of Birth'])[2]/following::select[3]";

        String email_selector = "//*[@id = 'contact-email']";
        String addy1_selector = "//*[@id = 'contact-address1']";
        String addy2_selector = "//*[@id = 'contact-address2']";
        String city_selector = "//*[@id = 'contact-city']";
        String postcode_selector = "//*[@id = 'contact-postcode']";
        String continue_btn_selector = "(//button[@type = 'submit'])[3]";
        String country_selector = "//*[@id = 'contact-country']";
        String phone_selector = "//*[@id = 'contact-mobile']";

        Select title1 = new Select(webSupport.getElement(adult1_title_selector));
        Select dob_day1 = new Select(webSupport.getElement(adult1_DOB_day_selector));
        Select dob_month1 = new Select(webSupport.getElement(adult1_DOB_month_selector));
        Select dob_year1 = new Select(webSupport.getElement(adult1_DOB_year_selector));


        Select title2 = new Select(webSupport.getElement(adult2_title_selector));
        Select dob_day2 = new Select(webSupport.getElement(adult2_DOB_day_selector));
        Select dob_month2 = new Select(webSupport.getElement(adult2_DOB_month_selector));
        Select dob_year2 = new Select(webSupport.getElement(adult2_DOB_year_selector));
        Select country = new Select(webSupport.getElement(country_selector));

        title1.selectByValue(employee.getEmp_A().getTitle());
        webSupport.enterText(adult1_firstNameSelector, employee.getEmp_A().getFirstName());
        webSupport.enterText(adult1_lastName_selector, employee.getEmp_A().getLastName());
        dob_day1.selectByValue(employee.getEmp_A().getDOB_Day());
        dob_month1.selectByVisibleText(employee.getEmp_A().getDOB_Month());
        dob_year1.selectByValue(employee.getEmp_A().getDOB_Year());
        title2.selectByValue(employee.getEmp_B().getTitle());
        webSupport.enterText(adult2_firstNameSelector, employee.getEmp_B().getFirstName());
        webSupport.enterText(adult2_lastName_selector, employee.getEmp_B().getLastName());
        dob_day2.selectByValue(employee.getEmp_B().getDOB_Day());
        dob_month2.selectByVisibleText(employee.getEmp_B().getDOB_Month());
        dob_year2.selectByValue(employee.getEmp_B().getDOB_Year());

        webSupport.enterText(phone_selector, supplierDetail.getPhoneNumber1());
        webSupport.enterText(email_selector, employee.getEmp_A().getEmail());
        webSupport.enterText(addy1_selector, employee.getEmp_A().getAddress1());
        webSupport.enterText(addy2_selector, employee.getEmp_A().getAddress2());
        webSupport.enterText(city_selector, employee.getEmp_A().getCity());
        country.selectByVisibleText(employee.getEmp_A().getCountry());
        webSupport.enterText(postcode_selector, employee.getEmp_A().getPostcode());

        try {
            webSupport.click(continue_btn_selector);
        } catch (WebDriverException e) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) By.xpath("//h1[text() = 'India']")));

    }

    public void fillPaymentForm() {
    }
}
