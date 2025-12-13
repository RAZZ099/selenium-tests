package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PricingPage extends BasePage {

    @FindBy(xpath = "//p[@data-price='publisher']")
    private WebElement publisherPriceInitial;

    @FindBy(xpath = "//a[contains(@href, 'signup') and contains(text(), 'Try for free')]")
    private WebElement tryForFreeLinkStarter;

    @FindBy(xpath = "//input[@id='members']")
    private WebElement sliderInput;

    @FindBy(xpath = "//span[contains(@class, 'js-tooltip-count')]")
    private WebElement audienceMembersNo;

    @FindBy(xpath = "//p[@data-price='publisher']")
    private WebElement publisherPriceUpdated;

    @FindBy(xpath = "//a[contains(@href, 'signup') and contains(text(), 'Try for free')]")
    private WebElement tryForFreeLinkStarter2;


    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage verifyInitialPublisherPrice() {
        String publisherPriceTextInitial = publisherPriceInitial.getText();
        Assert.assertEquals(publisherPriceTextInitial, "29");
        return this;
    }

    public PricingPage verifyTryForFreeEnabledInitially() {
        String classesTryForFreeLinkStarter = tryForFreeLinkStarter.getAttribute("class");
        Assert.assertFalse(classesTryForFreeLinkStarter.contains("opacity-60 cursor-not-allowed"));
        return this;
    }

    public PricingPage moveSliderTo25k() {
        while (!(audienceMembersNo.getText().contains("25k"))) {
            sliderInput.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public PricingPage waitForUpdatedPrice() {
        By publisherPriceBy = By.xpath("//p[@data-price='publisher']");
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        customWait.until(ExpectedConditions.textToBePresentInElementLocated(publisherPriceBy, "141"));
        return this;
    }

    public PricingPage verifyUpdatedPublisherPrice() {
        String publisherPriceTextUpdated = publisherPriceUpdated.getText();
        Assert.assertEquals(publisherPriceTextUpdated, "141");
        return this;
    }

    public PricingPage verifyTryForFreeDisabledAfterUpdate() {
        String classesTryForFreeLinkStarter2 = tryForFreeLinkStarter2.getAttribute("class");
        Assert.assertTrue(classesTryForFreeLinkStarter2.contains("opacity-60 cursor-not-allowed"));
        return this;
    }
}
