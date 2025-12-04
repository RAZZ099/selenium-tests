package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="email")
    public  WebElement email;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(id="submit")
    public WebElement submitButton;

    public void login(String userEmail, String userPassword){
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        submitButton.click();
    }

    }


