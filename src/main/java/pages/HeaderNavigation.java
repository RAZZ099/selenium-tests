package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderNavigation extends BasePage {

    @FindBy(xpath = "//button[span[text()='Resources']]")
    private WebElement resourcesButton;

    @FindBy(xpath = "//p[contains(text(),'Start here')]")
    private WebElement startHereButton;

    @FindBy(xpath = "//a[text()='Pricing']")
    private WebElement pricingButton;

    public HeaderNavigation(WebDriver driver) {
        super(driver);
    }

    public void clickResourcesButton() {
        resourcesButton.click();
    }

    public ResourcesPage clickStartHereButton() {
        startHereButton.click();
        return new ResourcesPage(driver);
    }

    public PricingPage clickPricingButton() {
        pricingButton.click();
        return new PricingPage(driver);
    }

}
