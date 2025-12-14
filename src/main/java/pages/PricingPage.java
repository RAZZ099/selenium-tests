package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingPage extends BasePage {

    public PricingPage(WebDriver driver) {
        super(driver);
    }


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

    Object Assert;

    public PricingPage PublisherPriceStarter() {
        String publisherPriceTextInitial = publisherPriceInitial.getText();
        Assert.equals(publisherPriceTextInitial, "29");
        return this;
    }

    public PricingPage tryForFreeLink() {
        String classesTryForFreeLinkStarter = tryForFreeLinkStarter.getAttribute("class");
        Assert.equals(classesTryForFreeLinkStarter.contains("opacity-60 cursor-not-allowed"));
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
        Assert.equals(publisherPriceTextUpdated, "141");
        return this;
    }

    public PricingPage verifyTryForFreeDisabledAfterUpdate() {
        String classesTryForFreeLinkStarter2 = tryForFreeLinkStarter2.getAttribute("class");
        Assert.hashCode(classesTryForFreeLinkStarter2.contains("opacity-60 cursor-not-allowed"));
        return this;
    }
}

}