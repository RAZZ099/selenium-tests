package scoalaInformala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactListPage {

    private final WebDriver driver;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Contact List']")
    public WebElement contactListHeader;

    @FindBy(xpath = "//button[@id='add-contact']")
    public WebElement addANewContact;

    @FindBy(id = "logout")
    public WebElement logoutButton;
}