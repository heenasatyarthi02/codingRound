package Base;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebDriverLibrary {

    private WebDriver webDriver;

    public WebDriverLibrary(WebDriver webDriver) {
        this.webDriver = webDriver;
        setChromeDriverPath();
    }

    private void setChromeDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

    public void findElement(WebElement webElement) {
      webDriver.findElement((By) webElement);
    }

    public void findElementAndClick(WebElement webElement) {
        webDriver.findElement((By) webElement).click();
    }

    public void findElementAndClear(WebElement webElement) {
        webDriver.findElement((By) webElement).click();
    }

    public void findElementAndEnterText(WebElement webElement , CharSequence text) {
        webDriver.findElement((By) webElement).sendKeys(text);
    }

    public boolean isElementPresentOnScreen(WebElement webElement){
        try {
            webDriver.findElement((By) webElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String findElementAndReturnText(WebElement webElement){
        return webDriver.findElement((By)webElement).getText();
    }

    public void get(String url){
        webDriver.get(url);
    }

    public List<WebElement> findElementsInAListByTagName(WebElement list, WebElement elements){
        return webDriver.findElement((By) list).findElements((By) elements);
    }

    public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}


//webDriver.get("https://www.cleartrip.com/");
