package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddContactPage {
    WebDriver driver;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="firstName")
    public WebElement firstNameInput;
    @FindBy(id="lastName")
    public WebElement lastNameInput;
    @FindBy(id="birthdate")
    public WebElement birthDateInput;
   @FindBy(id="email")
   public WebElement emailInput;
   @FindBy(id="phone")
    public WebElement phoneInput;
   @FindBy(id="submit")
    public WebElement submitButton;

   public void addContact(String firstName, String lastName,String birthDate, String email, String phone){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(firstNameInput));

       firstNameInput.sendKeys(firstName);
       lastNameInput.sendKeys(lastName);
       birthDateInput.sendKeys(birthDate);
       emailInput.sendKeys(email);
       phoneInput.sendKeys(phone);
       submitButton.click();

    }
}
