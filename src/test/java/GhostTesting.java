import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;
import scoalaInformala.*;

import java.time.*;

public class GhostTesting {
    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ghost.org/");

        StartHerePage startHerePage = new StartHerePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startHereHeader = wait.until(ExpectedConditions.visibilityOf(startHerePage.startHereHeader));
        Assert.assertTrue(startHereHeader.isDisplayed());

        GhostLandingPage ghostLandingPage = new GhostLandingPage(driver);
        ghostLandingPage.resourceButton.click();
        ghostLandingPage.startHere.click();
        ghostLandingPage.searchInput.sendKeys("create new blog");

        WebElement tenthItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ais-Hits-item search-result-item'][10]")));
        ghostLandingPage.tenthItem.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(ghostLandingPage.pricingButton).perform();
        ghostLandingPage.pricingButton.click();

        PricingPage pricingPage = new PricingPage(driver);
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pricingHeader = waits.until(ExpectedConditions.visibilityOf(pricingPage.pricingHeader));
        Assert.assertTrue(pricingHeader.isDisplayed());

        WebElement moveslider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='members']")));
        Actions slider = new Actions(driver);
        slider.clickAndHold(moveslider)
                .moveByOffset(5, 0)
                .release()
                .perform();
    }
}