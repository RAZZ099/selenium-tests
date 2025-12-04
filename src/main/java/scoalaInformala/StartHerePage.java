package scoalaInformala;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class StartHerePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public StartHerePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='flex justify-start']")
    public WebElement startHereHeader;
}

