import model.Employee;
import model.EmployeeBuilder;
import org.testng.Assert;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.EmployeeApiSupport;
import support.CreateWebDriver;
import support.WebSupport;
import java.io.IOException;

public class MailTravelTest {

    private static WebDriver driver;
    static WebSupport wSupport;
    static EmployeeApiSupport aSupport;
    static EmployeeBuilder aEmployee;
    static Header header;
    static Results results;
    static SupplierDetail supplierDetail;
    static BookingPage bookingPage;
    static BookingSummary bookingSummary;

    @BeforeClass
    public static void startUp() throws IOException {
        driver = CreateWebDriver.getDriver();
        wSupport = new WebSupport(driver);
        aSupport = new EmployeeApiSupport();
        aEmployee = new EmployeeBuilder();
        header = new Header(driver);
        results =new Results(driver);
        supplierDetail =new SupplierDetail(driver);
        bookingPage = new BookingPage(driver);
        bookingSummary = new BookingSummary(driver);
    }

    @Test
    public void UI_Test() throws IOException, InterruptedException {

        wSupport.gotoPage("https://www.mailtravel.co.uk/");
        header.travelSearch("India");
        results.selectProduct("11 Days - Classic Escorted Tours");

        Assert.assertTrue(supplierDetail.getDisplayedPhoneNos()
                .equals(supplierDetail.getPhoneNumber1()) | supplierDetail.getDisplayedPhoneNos()
                .equals(supplierDetail.getPhoneNumber2()));
        //assert days and price displayed

        supplierDetail.bookOnline();
        bookingPage.fillDateDepartureForm();
        bookingPage.fillAccommodationForm();
        bookingPage.fillExtrasForm();
        bookingPage.fillPassengerDetailsForm();
        bookingPage.fillPaymentForm();
        Assert.assertEquals(bookingSummary.getActualDisplayedAmount(), bookingSummary.getTotalBookingAmount());
    }

    @Test
    public void API_GetEmployeesTest() throws IOException {

        aSupport.getAllEmployeeRecords("/employees");
    }

    @Test
    public void API_CreateEmployeeTest() throws IOException {
        aSupport.createEmployeeRecord("/create");
    }

    @AfterClass
    public static void clearDown() {
        driver.close();
    }
}
