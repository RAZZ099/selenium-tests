import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class createUserTests {
    @Test
    public static void createUser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement EmailInput=driver.findElement(By.id("email"));
        EmailInput.sendKeys("edith1@test.com");

        WebElement passwordInput=driver.findElement(By.id("password"));
        passwordInput.sendKeys("edith11..");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logoutButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
        logoutButton.click();

        driver.close();



    }
}
