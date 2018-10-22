import Base.WebDriverLibrary;
import Screens.FlightBooking;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {

    private WebDriver webDriver;
    private WebDriverLibrary webDriverLibrary;
    private FlightBooking flightBooking;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverLibrary = new WebDriverLibrary(webDriver);
        webDriverLibrary.get("https://www.cleartrip.com");
        flightBooking = new FlightBooking();
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        webDriverLibrary.waitFor(2000);
        webDriverLibrary.findElementAndClick(flightBooking.getOneWay());
        webDriverLibrary.findElementAndClear(flightBooking.getFromTag());
        webDriverLibrary.findElementAndEnterText(flightBooking.getFromTag(), "Bangalore");
        //wait for the auto complete options to appear for the origin
        webDriverLibrary.waitFor(2000);
        List<WebElement> originOptions = webDriverLibrary.findElementsInAListByTagName(flightBooking.getUi_id_1(), flightBooking.getLi());
        originOptions.get(0).click();
        webDriverLibrary.findElementAndClear(flightBooking.getToTag());
        webDriverLibrary.findElementAndEnterText(flightBooking.getToTag(), "Delhi");
        //wait for the auto complete options to appear for the destination
        webDriverLibrary.waitFor(2000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = webDriverLibrary.findElementsInAListByTagName(flightBooking.getUi_id_2(), flightBooking.getLi());
        destinationOptions.get(0).click();
        webDriverLibrary.findElementAndClick(flightBooking.getDatePicker());
        //all fields filled in. Now click on search
        webDriverLibrary.findElementAndClick(flightBooking.getSearchBtn());
        webDriverLibrary.waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(webDriverLibrary.isElementPresentOnScreen(flightBooking.getSearchSummary()));
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
