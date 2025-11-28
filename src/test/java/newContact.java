import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class newContact {
    @Test
    public static void addContact(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement EmailInput=driver.findElement(By.id("email"));
        EmailInput.sendKeys("craciunescwoo@test.com");

        WebElement passwordInput=driver.findElement(By.id("password"));
        passwordInput.sendKeys("thewordpass");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement addNewContactButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact")));
        addNewContactButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Horia");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Brenciu");

        WebElement dateOfBirth = driver.findElement(By.id("birthdate"));
        dateOfBirth.sendKeys("1992-02-02");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("craciunescwoo@test.com");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("0762924568");

        WebElement submitButton2 = driver.findElement(By.id("submit"));
        submitButton2.click();


    }
}