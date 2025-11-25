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
    @FindBy(id = "add-contact")
    public WebElement addContact;

    @FindBy(id = "firstName")
    public WebElement fistNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(id = "birthdate")
    public WebElement birthDateInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "street1")
    public WebElement streetAdress1Input;

    @FindBy(id = "street2")
    public WebElement streetAdress2Input;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "stateProvince")
    public WebElement stateOrProvinceInput;

    @FindBy(id = "postalCode")
    public WebElement postalCodeInput;

    @FindBy(id = "country")
    public WebElement countryInput;

    @FindBy(id = "submit")
    public WebElement submitButton;


}