package scoalaInformala;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListTest {


    public static void addNewContactScenario() {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            String userEmail = "elena.bianca@yahoo.com";
            String userPassword = "Bianca123!";

            String newFirstName = "Mihai";
            String newLastName = "Eminescu";

            String newUniqueEmail = newFirstName.toLowerCase() + "." + newLastName.toLowerCase() + System.currentTimeMillis() + "@test.com";


            LandingPage landingPage = new LandingPage(driver);


            landingPage.emailInput.sendKeys(userEmail);
            landingPage.passwordInput.sendKeys(userPassword);
            landingPage.submitButton.click();

            ContactListPage contactListPage = new ContactListPage(driver);
            wait.until(ExpectedConditions.visibilityOf(contactListPage.contactListHeader));
            contactListPage.addANewContact.click();

            wait.until(ExpectedConditions.urlContains("/addContact"));


            AddContactPage addContactPage = new AddContactPage(driver);

            addContactPage.firstNameInput.sendKeys(newFirstName);
            addContactPage.lastNameInput.sendKeys(newLastName);
            addContactPage.emailInput.sendKeys(newUniqueEmail);
            addContactPage.birthdateInput.sendKeys("1998-05-21");
            addContactPage.countryInput.sendKeys("Romania");

            addContactPage.submitButton.click();

            wait.until(ExpectedConditions.visibilityOf(contactListPage.contactListHeader));

            String contactXpath = String.format("//span[text()='%s, %s']", newLastName, newFirstName);
            WebElement newContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contactXpath)));

        }
    }

    public static void main(String[] args) {
        addNewContactScenario();
    }
}