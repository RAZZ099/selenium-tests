import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import scoalaInformala.ghostPOM.NavigationHeader;

import java.time.Duration;

public class GhostTest {


    @Test
    public static void GhostTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ghost.org/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        NavigationHeader navigationHeader = new NavigationHeader(driver);


        navigationHeader.resourcesButton.click();

        navigationHeader.startHereButton.click();

        navigationHeader.searchInput.click();

        navigationHeader.searchInput.sendKeys("create new blog");
        wait.until(ExpectedConditions.elementToBeClickable(navigationHeader.tenthResult)).click();

        Actions actions = new Actions(driver);

        actions.moveToElement(navigationHeader.pricingButton).perform();
        navigationHeader.pricingButton.click();
    }
}
