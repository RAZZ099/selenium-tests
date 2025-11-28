package scoalaInformala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

    private final WebDriver driver;

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "birthdate")
    public WebElement birthdateInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(id = "street1")
    public WebElement street1Input;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "stateProvince")
    public WebElement stateProvinceInput;

    @FindBy(id = "postalCode")
    public WebElement postalCodeInput;

    @FindBy(id = "country")
    public WebElement countryInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;
}