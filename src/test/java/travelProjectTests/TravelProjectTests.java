package travelProjectTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import scoalaInformala.LandingPage;
import scoalaInformala.ContactListPage;
import utils.Utils;

import java.time.Duration;
import java.util.List;

public class TravelProjectTests {


    @Test
    public static void login(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easyjet.com/en/");

        driver.findElement(By.id("ensCloseBanner")).click();
        driver.findElement(By.className("TextBox_clearButton__NXFRp")).click();
        driver.findElement(By.cssSelector("input[name='from']")).sendKeys("New York");

        // List<WebElement> fromOptions = driver.findElements(By.xpath("//span[@data-testid='airport-name']"));
        List<WebElement> fromOptions = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@data-testid='airport-name']")));
        for (WebElement option : fromOptions) {
                // System.out.println(option.getText());
                if(option.getText().contains("Kennedy")) {
                    option.click();
                    break;
                }
        }

        driver.findElement(By.cssSelector("input[name='to']")).sendKeys("Paris");

        List<WebElement> toOptions = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@data-testid='airport-name']")));
        for (WebElement option : toOptions) {
                // System.out.println(option.getText());
                if(option.getText().contains("Charles de Gaulle")) {
                    option.click();
                    break;
                }
        }


        WebElement whenElement = driver.findElement(By.id("when"));
        whenElement.click();
        WebElement dateElement = driver.findElement(By.xpath("//button[@ data-testid='4-12-2025']"));
        dateElement.click();

        WebElement who = driver.findElement(By.id("who"));
        who.click();

        WebElement addAdultButton = driver.findElement(By.xpath("//button[@aria-label='Add one adult']"));
        addAdultButton.click();

        WebElement addChildButton = driver.findElement(By.xpath("//button[@aria-label='Add one child']"));
        addChildButton.click();
        addChildButton.click();

        WebElement addInfantButton = driver.findElement(By.xpath("//button[@aria-label='Add one infant']"));
        addInfantButton.click();

        // //button[@data-testid="close-button"]
        WebElement closeWhoElement = driver.findElement(By.xpath("//button[@data-testid='close-button']"));
        closeWhoElement.click();

        // data-testid="submit"
        WebElement submitElement = driver.findElement(By.xpath("//button[@data-testid='submit']"));
        submitElement.click();






    }


        



}
