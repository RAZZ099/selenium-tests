package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class addNewContact {
        @Test
        public static void addnewcontact(){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            LandingPage landingpage = new LandingPage(driver);

            landingpage.addNewContact.click();
            landingpage.firstname.sendKeys("Edith");
            landingpage.lastname.sendKeys("M");
            landingpage.birthday.sendKeys("2003-02-01");
            landingpage.email.sendKeys("edith123@test.com");
            landingpage.phone.sendKeys("0749456789");
            landingpage.submitButton.click();

        }
    }

