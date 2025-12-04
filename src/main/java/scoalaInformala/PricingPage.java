package scoalaInformala;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class PricingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PricingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='relative max-w-8xl mx-auto pb-[12vmin] pt-[8vmin] text-center']")
    public WebElement pricingHeader;
}
