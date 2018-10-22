import Base.WebDriverLibrary;
import Screens.SignIn;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    private WebDriver webDriver;
    private WebDriverLibrary webDriverLibrary;
    private SignIn signIn;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverLibrary = new WebDriverLibrary(webDriver);
        webDriverLibrary.get("https://www.cleartrip.com");
        signIn = new SignIn();
    }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        webDriverLibrary.waitFor(2000);
        webDriverLibrary.findElementAndClick(signIn.getYourTrips());
        webDriverLibrary.findElementAndClick(signIn.getSignIn());
        webDriverLibrary.findElementAndClick(signIn.getSignInBtn());
        String errors1 = webDriverLibrary.findElementAndReturnText(signIn.getErrors1());
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
