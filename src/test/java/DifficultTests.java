import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

import java.time.Duration;

public class DifficultTests {

    private WebDriver driver;
    /*
    Using any language, framework and design pattern please write an
    automated test that performs the following:
    A. Navigate to https://ghost.org/
    B. Navigate to "Start here" section using the "Resources" menu.
    C. Search for “create new blog”
    D. Open the 10th result
    E. Scroll to the top of the page and open the “Pricing” section
    F. Change the “Based on an audience” slider to 25k members and verify that all the
    prices have increased.
     */

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeDriver();
    }


    @Test
    public void ghostTestPom() {
//        A. Navigate to https://ghost.org/
        HomePage homePage = new HomePage(driver);
        homePage.open();
//        B. Navigate to "Start here" section using the "Resources" menu.
        HeaderNavigation headerNavigation = new HeaderNavigation(driver);
        headerNavigation.clickResourcesButton();
        ResourcesPage resourcesPage = headerNavigation.clickStartHereButton();
//        C. Search for “create new blog”
        resourcesPage.searchFor("create new blog");
//        D. Open the 10th result
        BlogPage blogPage = resourcesPage.clickTenthSearchResult();
//        E. Scroll to the top of the page and open the “Pricing” section
        PricingPage pricingPage = headerNavigation.clickPricingButton();
//        F. Change the “Based on an audience” slider to 25k members and verify that all the
//        prices have increased.
        pricingPage.tryForFree();
        pricingPage.verifyPublisherPriceInitial();
        pricingPage.verifyBusinessPriceInitial();
        pricingPage.moveSlider();
        pricingPage.updatedPublisherPrice();
        pricingPage.updatedBusinessPrice();
        pricingPage.tryForFree2();







    }



    @Test
    public void firstTest(){

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

        WebElement publisherPriceInitial = driver.findElement(By.xpath("//p[@data-price='publisher']"));

        String publisherPriceTextInitial = publisherPriceInitial.getText();

        Assert.assertEquals(publisherPriceTextInitial, "29");

        WebElement tryForFreeLinkStarter = driver.findElement(By.xpath("//a[contains(@href, 'signup') and contains(text(), 'Try for free')]"));
        String classesTryForFreeLinkStarter = tryForFreeLinkStarter.getAttribute("class");
        Assert.assertFalse(classesTryForFreeLinkStarter.contains("opacity-60 cursor-not-allowed"));

        WebElement sliderInput = driver.findElement(By.xpath("//input[@id='members']"));

        WebElement audienceMembersNo = driver.findElement(By.xpath("//span[contains(@class, 'js-tooltip-count')]"));

        while (!(audienceMembersNo.getText().contains("25k"))) {
            sliderInput.sendKeys(Keys.ARROW_RIGHT);
        }


        By publisherPriceBy = By.xpath("//p[@data-price='publisher']");

        WebElement publisherPriceUpdated = driver.findElement(By.xpath("//p[@data-price='publisher']"));

        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        customWait.until(ExpectedConditions.textToBePresentInElementLocated(publisherPriceBy, "141"));

        String publisherPriceTextUpdated = publisherPriceUpdated.getText();

        Assert.assertEquals(publisherPriceTextUpdated, "141");

        WebElement tryForFreeLinkStarter2 = driver.findElement(By.xpath("//a[contains(@href, 'signup') and contains(text(), 'Try for free')]"));
        String classesTryForFreeLinkStarter2 = tryForFreeLinkStarter2.getAttribute("class");
        Assert.assertTrue(classesTryForFreeLinkStarter2.contains("opacity-60 cursor-not-allowed"));



    }



}
