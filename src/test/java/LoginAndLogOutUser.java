import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;


  public class LoginAndLogOutUser {

      @Test
      public static void logInLogOut(){

    WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("elena.bianca@yahoo.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Bianca123!");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement contactListHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Contact List']")));
        Assert.assertTrue(contactListHeader.isDisplayed());


        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();


        WebElement loginButtonAfterLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        Assert.assertTrue(loginButtonAfterLogout.isDisplayed());

        driver.close();
    }
}
