package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
    WebDriver driver;
    public WebElement addNewContact;
    public WebElement firstname;
    public WebElement lastname;
    public WebElement birthday;
    public WebElement email;
    public WebElement phone;
    public WebElement submitButton;


    public LandingPage(WebDriver driver) {
        this.driver=driver;
        this.addNewContact= driver.findElement(By.id("add-contact"));
        this.firstname= driver.findElement(By.id("firstname"));
        this.lastname= driver.findElement(By.id("lastname"));
        this.birthday= driver.findElement(By.id("birthdate"));
        this.email= driver.findElement(By.id("email"));
        this.phone=driver.findElement(By.id("phone"));
        this.submitButton= driver.findElement(By.id("submit"));




    }

}
