import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class unNouContact {
    @Test
    public static void addContact(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement EmailInput=driver.findElement(By.id("email"));
        EmailInput.sendKeys("edith1@test.com");

        WebElement passwordInput=driver.findElement(By.id("password"));
        passwordInput.sendKeys("edith11..");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement addNewContactButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact")));
        addNewContactButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Edith");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("M");

        WebElement dateOfBirth = driver.findElement(By.id("birthdate"));
        dateOfBirth.sendKeys("2003-02-01");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("edith123@test.com");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("0749456789");

        WebElement submitButton2 = driver.findElement(By.id("submit"));
        submitButton2.click();


    }
}
