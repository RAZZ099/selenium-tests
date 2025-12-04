import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class UnusualTest {

    public void cookiesTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kostal-solar-portal.com/#/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement cookies = (WebElement) js.executeScript("return document.querySelector('#usercentrics-root').shadowRoot.querySelector(\"button[data-testid='uc-accept-all-button']\");");
        cookies.click();

    }
}
