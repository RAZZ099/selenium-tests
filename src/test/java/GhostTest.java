import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import scoalaInformala.ghostpom.NavigationHeaderPage;

import java.time.Duration;

public class GhostTest {


    @Test
    public static void ghostTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ghost.org/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        NavigationHeaderPage navHeaderPage = new NavigationHeaderPage(driver);


        navHeaderPage.resourcesButton.click();

        navHeaderPage.startHereButton.click();

        navHeaderPage.searchInput.click();

        navHeaderPage.searchInput.sendKeys("create new blog");
        wait.until(ExpectedConditions.elementToBeClickable(navHeaderPage.tenthResult)).click();

        Actions actions = new Actions(driver);

        actions.moveToElement(navHeaderPage.pricingButton).perform();
        navHeaderPage.pricingButton.click();
    }
}