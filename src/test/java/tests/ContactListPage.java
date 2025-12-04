package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage {
    WebDriver driver;

    public ContactListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="add-contact")
    public WebElement addContactButton;

    public void clickAddContact(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
        addContactButton.click();
    }

    }

