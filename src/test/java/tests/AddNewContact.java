package tests;

import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddNewContact {
        @Test
        public static void login(){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com");

            LandingPage landingpage = new LandingPage(driver);
//            landingpage.email.sendKeys("edith1@test.com");
//            landingpage.password.sendKeys("edith11..");
//            landingpage.submitButton.click();
            landingpage.login("edith1@test.com", "edith11..");

            ContactListPage contactListPage = new ContactListPage(driver);
            contactListPage.clickAddContact();

            AddContactPage addContactPage = new AddContactPage(driver);
            addContactPage.addContact("Edith", "M", "2003-02-01", "edith123@test.com", "0749456789");

            driver.quit();



        }
    }

