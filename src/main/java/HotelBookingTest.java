import Base.WebDriverLibrary;
import Screens.HotelBooking;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    private WebDriver webDriver;
    private WebDriverLibrary webDriverLibrary;
    private HotelBooking hotelBooking;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverLibrary = new WebDriverLibrary(webDriver);
        webDriverLibrary.get("https://www.cleartrip.com");
        hotelBooking = new HotelBooking();
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        webDriverLibrary.findElementAndClick(hotelBooking.getHotelLink());
        webDriverLibrary.findElementAndEnterText(hotelBooking.getLocalityTextBox(),"Indiranagar, Bangalore");
        new Select(hotelBooking.getTravellerSelection()).selectByVisibleText("1 room, 2 adults");
        webDriverLibrary.findElementAndClick(hotelBooking.getSearchButton());
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
