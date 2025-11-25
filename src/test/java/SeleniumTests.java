import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import scoalaInformala.AddContactPage;
import scoalaInformala.ContactDetails;
import scoalaInformala.ContactListPage;
import scoalaInformala.LandingPage;
import utils.Utils;
import java.awt.*;
import java.time.Duration;

public class SeleniumTests {


        @Test
        public static void createUser () {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

            WebElement signUpButton = driver.findElement(By.id("signup"));
            signUpButton.click();

            WebElement firstNameInput = driver.findElement(By.id("firstName"));
            firstNameInput.sendKeys("Razvan");

            WebElement lastNameInput = driver.findElement(By.id("lastName"));
            lastNameInput.sendKeys("Pruteanu");

            WebElement emailInput = driver.findElement(By.id("email"));
            emailInput.sendKeys(Utils.generateRandomEmail());

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("JKDHAKDHiiufd*&*&98_");

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            WebElement contactListHeaderFound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Contact List']")));
            Assert.assertTrue(contactListHeaderFound.isDisplayed());

            driver.close();
        }

        @Test
        public static void login () {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/");

            LandingPage landingPage = new LandingPage(driver);
            landingPage.emailInput.sendKeys("testr@tesr.com");
            landingPage.passwordInput.sendKeys("testr123456789");
            landingPage.submitButton.click();

            ContactListPage contactListPage = new ContactListPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement contactListHeader = wait.until(ExpectedConditions.visibilityOf(contactListPage.contactListHeader));
            Assert.assertTrue(contactListHeader.isDisplayed());

            driver.close();
        }


        @Test
        public static void AddNewContact () {

            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");


            AddContactPage addContactPage = new AddContactPage(driver);
            addContactPage.addContact.click();

            addContactPage.fistNameInput.sendKeys("George");
            addContactPage.lastNameInput.sendKeys("Burlacu");
            addContactPage.phoneInput.sendKeys("0749461182");
            addContactPage.birthDateInput.sendKeys("1991-06-20");
            addContactPage.emailInput.sendKeys("abcde@test.com");
            addContactPage.streetAdress1Input.sendKeys("Strada Principala nr 1");
            addContactPage.streetAdress2Input.sendKeys("Strada Secundara nr 2");
            addContactPage.cityInput.sendKeys("Braila");
            addContactPage.stateOrProvinceInput.sendKeys("Braila");
            addContactPage.postalCodeInput.sendKeys("123456");
            addContactPage.countryInput.sendKeys("Romania");
            addContactPage.submitButton.click();

            // Fara Try and Catch nu am reusit sa trec de "Save Adress"
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement noThanksButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(), 'No thanks') or contains(text(), 'Not now') or contains(text(), 'Cancel')]")));
                noThanksButton.click();
            } catch (Exception e) {
            }


            ContactDetails contactDetails = new ContactDetails(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement contactDetailsPage = wait.until(ExpectedConditions.visibilityOf(contactDetails.contactDetailsPage));
            Assert.assertTrue(contactDetailsPage.isDisplayed());
        }

    }