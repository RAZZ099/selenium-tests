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


}
