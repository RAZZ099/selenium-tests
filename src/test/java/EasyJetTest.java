import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class EasyJetTest {


    @Test
    public static void scheduleFlight() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easyjet.com/en");

        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@aria-label = 'Accept Cookies']"));
        acceptCookiesButton.click();

        WebElement clearDepartureButton = driver.findElement(By.xpath("//button[@aria-label='Clear selected departure airport']"));
        clearDepartureButton.click();

        WebElement fromTextImput = driver.findElement(By.xpath("//input[@id='from']"));
        fromTextImput.sendKeys("New York");

        List<WebElement> fromOptions = driver.findElements(By.xpath("//span[@data-testid='aiport-name']"));
        for (WebElement option : fromOptions) {
            System.out.println(option.getText());
            if (option.getText().contains("Kennedy")) {
                option.click();
                break;
            }
        }
        WebElement toTextImput = driver.findElement(By.xpath("//input[@id='to']"));
        toTextImput.sendKeys("Paris");

        WebElement toCharlesDeGaulle = driver.findElement(By.xpath("//span[@data-testid=\"airport-name\" and contains(.,'Gaulle')]"));
        toCharlesDeGaulle.click();

        WebElement whenPickerInput = driver.findElement(By.xpath("//input[@id='when']"));
        whenPickerInput.click();

        WebElement dataPicker = driver.findElement(By.xpath("//button[@data-testid='12-12-2025']"));
        dataPicker.click();

        WebElement whoInput = driver.findElement(By.xpath("//input[@id='who']"));
        whoInput.click();

        WebElement adultButton = driver.findElement(By.xpath("//button[@aria-label='Add one adult']"));
        adultButton.click();

        WebElement addChild = driver.findElement(By.xpath("//button[@aria-label='Add one child']"));
        addChild.click();
        addChild.click();

        WebElement addInfant = driver.findElement(By.xpath("//button[@aria-label='Add one infant']"));
        addInfant.click();

        WebElement applyButton = driver.findElement(By.xpath("//button[@data-testid='close-button']"));
        applyButton.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@data-testid='submit']"));
        submitButton.click();

        driver.close();
    }

}
