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

public class SeleniumTests {


    @Test
    public static void createUser(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement loginbutton = driver.findElement(By.id("email"));
        loginbutton.click();
        loginbutton.sendKeys("popeye@popeye.com");

        WebElement passwordButton = driver.findElement(By.id("password"));
        passwordButton.click();
        passwordButton.sendKeys("popeye123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        logoutButton.click();





    }


}
