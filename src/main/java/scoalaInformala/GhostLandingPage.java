package scoalaInformala;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class GhostLandingPage {
    private final WebDriver driver;

    public GhostLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[span[text()='Resources']]")
    public WebElement resourceButton;

    @FindBy(xpath = "//p[contains(text(),'Start here')]")
    public WebElement startHere;

    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchInput;

    @FindBy(xpath = "//li[@class='ais-Hits-item search-result-item'][10]")
    public WebElement tenthItem;

    @FindBy(xpath = "//a[text()='Pricing']")
    public WebElement pricingButton;
}
