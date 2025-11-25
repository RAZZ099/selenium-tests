package scoalaInformala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactDetails {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ContactDetails(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[text()='Contact List']")
    public WebElement contactDetailsPage;

    @FindBy(xpath = "/html/body/div/p[1]")
    public WebElement contactTable;


}

