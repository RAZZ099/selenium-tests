package scoalaInformala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[text()='Contact List']")
    public WebElement contactListHeader;

    @FindBy(xpath = "//button[@id='add-contact']")
    public WebElement addANewContact;

    
}
