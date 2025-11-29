import java.security.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GhostTest {



    /*
    Using any language, framework and design pattern please write an
    automated test that performs the following:
    A. Navigate to https://ghost.org/
    B. Navigate to "Start here" section using the "Resources" menu.
    C. Search for “create new blog”
    D. Open the 10th result
    E. Scroll to the top of the page and open the “Pricing” section
    F. Change the “Based on an audience” slider to 20k members and verify that all the
    prices have increased.
    */

    @Test
    public static void navigateGhost(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ghost.org/");

        WebElement resourcesButton = driver.findElement(By.xpath("(//button//span[text()='Resources'])"));
        resourcesButton.click();

        //         List<WebElement> fromOptions = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@data-testid='airport-name']")));
        // WebElement startHereLink = driver.findElement(By.xpath("//p[contains(text(), 'Start here')]"));

        // WebElement startHereLink = driver.findElement(By.xpath("//p[contains(text(), 'Start here')]")); using wait
        WebElement startHereLink = new WebDriverWait(driver, java.time.Duration.ofSeconds(20))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Start here')]")));
        startHereLink.click();

        WebElement searchBar = new WebDriverWait(driver, java.time.Duration.ofSeconds(20))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-input']")));

        searchBar.sendKeys("create new blog");

        // how to scroll using selenium actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBar);
        actions.click();
        actions.build().perform();

        WebElement searchResultTen = new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ais-Hits search-results']//li[10]")));

        searchResultTen.click();

        WebElement pricingButton = driver.findElement(By.xpath("//nav//a[contains(@href, 'pricing')]"));
        pricingButton.click();

        WebElement sliderInput = new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='members']")));

        sliderInput.sendKeys(Keys.ARROW_RIGHT);



        WebElement audienceMembersNo = driver.findElement(By.xpath("//div[@id=\"planselect\"]//span[contains(@class, 'pink')]"));
        
        while (!(audienceMembersNo.getText().contains("25,000"))) {
                sliderInput.sendKeys(Keys.ARROW_RIGHT);
                System.out.println("Current value: " + audienceMembersNo.getText());
        }

        WebElement startForFreeLink = driver.findElement(By.xpath("(//a[contains(@href, 'signup') and contains(text(), 'Try for free')])[1]"));
        String classesForStartForFreeLink = startForFreeLink.getAttribute("class");
        Assert.assertTrue(classesForStartForFreeLink != null && classesForStartForFreeLink.contains("cursor-not-allowed"), "Expected 'cursor-not-allowed' class when CTA is disabled");

        WebElement publisherPrice = driver.findElement(By.xpath("//p[@data-price='publisher']"));
        // String publisherPriceText = publisherPrice.getText();
        // Assert.assertTrue(publisherPriceText.contains("141"), "Expected price for publisher to be $141 for 25k members, but found: " + publisherPriceText);
        String publisherPriceText = new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
        .until(d -> {
            WebElement element = d.findElement(By.xpath("//p[@data-price='publisher']"));
            return element.getText().contains("141") ? element.getText() : null;
        });

        Assert.assertTrue(publisherPriceText.contains("141"), "Expected price for publisher to be $141 for 25k members, but found: " + publisherPriceText);


                // driver.close();
    }



        
    
        

        

}
