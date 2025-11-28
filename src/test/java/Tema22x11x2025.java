import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scoalaInformala.AddContactPage;
import scoalaInformala.ContactListPage;
import scoalaInformala.LandingPage;

import java.time.Duration;

public class Tema22x11x2025 {

    static WebDriver driver;
    static LandingPage landingPage;
    static AddContactPage addContactPage;
    static ContactListPage contactListPage;
@Test
    public void test() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    landingPage = new LandingPage(driver);
    addContactPage = new AddContactPage(driver);
    contactListPage = new ContactListPage(driver);

    landingPage.emailInput.sendKeys("Mihai13@gmail.com");
    landingPage.passwordInput.sendKeys("Mihai13");
    landingPage.submitButton.click();

    wait.until(ExpectedConditions.elementToBeClickable(contactListPage.addANewContact)).click();

    addContactPage.firstName.sendKeys("Mihai");
    addContactPage.lastName.sendKeys("Viteazul");
    addContactPage.birthdate.sendKeys("1990-09-10");
    addContactPage.email.sendKeys("Mihai13@gmail.com");
    addContactPage.phone.sendKeys("0777777777");
    addContactPage.street1.sendKeys("Strada 1");
    addContactPage.street2.sendKeys("Strada 2");
    addContactPage.city.sendKeys("Cluj");
    addContactPage.stateProvince.sendKeys("Cluj-Napoca");
    addContactPage.postalCode.sendKeys("025541");
    addContactPage.country.sendKeys("Romania");
    addContactPage.submit.click();

driver.quit();

    }
}