package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

import java.time.*;

public class PricingPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'signup') and contains(text(), 'Try for free')]")
    private WebElement tryForFreeLinkStarter;

    @FindBy(xpath = "//p[@data-price='publisher']")
    private WebElement publisherPriceInitial;

    @FindBy(xpath = "//p[@data-price='business']")
    private WebElement businessPriceInitial;

    @FindBy(xpath = "//input[@id='members']")
    private WebElement sliderInput;

    @FindBy(xpath = "//span[contains(@class, 'js-tooltip-count')]")
    private WebElement membersAudienceNo;

    public PricingPage(WebDriver driver) {
        super(driver);

    }

    public void tryForFree() {
        String classesTryForFreeLinkStarter = tryForFreeLinkStarter.getAttribute("class");
        Assert.assertFalse(classesTryForFreeLinkStarter.contains("opacity-60 cursor-not-allowed"));
    }

    public void verifyPublisherPriceInitial() {
        String publisherPriceTextInitial = publisherPriceInitial.getText();
        Assert.assertEquals(publisherPriceTextInitial, "29");

    }

    public void verifyBusinessPriceInitial() {
        String businessPriceTextInitial = businessPriceInitial.getText();
        Assert.assertEquals(businessPriceTextInitial, "199");
    }

    public void moveSlider() {
        while (!(membersAudienceNo.getText().contains("25k"))) {
            sliderInput.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void updatedPublisherPrice() {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        customWait.until(ExpectedConditions.textToBePresentInElement(publisherPriceInitial, "141"));
        String publisherPriceTextUpdated = publisherPriceInitial.getText();
        Assert.assertEquals(publisherPriceTextUpdated, "141");
    }

    public void updatedBusinessPrice() {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        customWait.until(ExpectedConditions.textToBePresentInElement(businessPriceInitial, "266"));
        String businessPriceTextUpdated = businessPriceInitial.getText();
        Assert.assertEquals(businessPriceTextUpdated, "266");
    }

    public void tryForFree2() {
        String classesTryForFreeLinkStarter = tryForFreeLinkStarter.getAttribute("class");
        Assert.assertTrue(classesTryForFreeLinkStarter.contains("opacity-60 cursor-not-allowed"));
    }
}
