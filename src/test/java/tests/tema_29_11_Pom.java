package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class tema_29_11_Pom {
    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ghost.org/");

        WebElement resourcesButton = driver.findElement(By.xpath("//button[span[text()='Resources']]"));
        resourcesButton.click();

        WebElement startHereButton = driver.findElement(By.xpath("//p[contains(text(),'Start here')]"));
        startHereButton.click();

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-input']"));
        searchInput.sendKeys("create new blog");

        WebElement tenthResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ais-Hits-item search-result-item'][10]")));
        tenthResult.click();

        WebElement pricingButton = driver.findElement(By.xpath("//a[text()='Pricing']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(pricingButton).perform();

        pricingButton.click();
    }

}



