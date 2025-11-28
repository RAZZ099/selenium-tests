package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement submitButton;
    WebElement signUpButton;

    public LandingPage(WebDriver driver) {
        this.driver=driver;
        this.emailInput= driver.findElement(By.id("email"));
        this.passwordInput= driver.findElement(By.id("password"));
        this.submitButton= driver.findElement(By.id("submit"));
        this.signUpButton= driver.findElement(By.id("signup"));



    }

}
