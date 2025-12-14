package pages;

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
    @FindBy (xpath = "//p[@data-price='publisher']")
    private WebElement publisherPrice;

    @FindBy(xpath = "//a[contains(@href, 'signup') and contains(text(), 'Try for free')]")
    private WebElement tryForFreeLinkStarter;

    @FindBy(xpath = "//input[@id='members']")
    private WebElement sliderInput;

    @FindBy(xpath = "//span[contains(@class, 'js-tooltip-count')]")
    private WebElement audienceMembersNo;


    public String getPublisherPriceText() {
        return publisherPrice.getText();
    }

    public String getClassesTryForFreeLinkStarter(){
        return tryForFreeLinkStarter.getAttribute("class");
    }
    public boolean isTryForFreeLinkStarterDisabled() {
        return tryForFreeLinkStarter.getAttribute("class").contains("opacity-60 cursor-not-allowed");
    }


    public void moveSliderTo25k(){
        while (!(audienceMembersNo.getText().contains("25k"))) {
            sliderInput.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void waitForPublisherPrice(String expectedPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(publisherPrice, expectedPrice));
    }



}
