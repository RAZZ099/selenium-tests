import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class EasyJetTests {

    @Test
    public static void scheduleFlight() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easyjet.com/en/");

        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@aria-label='Accept Cookies']"));
        acceptCookiesButton.click();

        WebElement clearDepatureButton =  driver.findElement(By.xpath("//button[@aria-label='Clear selected departure airport']"));
        clearDepatureButton.click();

        WebElement fromTextInput = driver.findElement(By.xpath("//input[@id='from']"));
//        fromTextInput.sendKeys("New York");
        fromTextInput.sendKeys("London");

        List<WebElement> fromOptions = driver.findElements(By.xpath("//span[@data-testid='airport-name']"));
        for (WebElement option : fromOptions) {
            System.out.println(option.getText());
            if(option.getText().contains("Luton")) {
                option.click();
                break;
            }
        }

        WebElement toTextInput = driver.findElement(By.xpath("//input[@id='to']"));
//        toTextInput.sendKeys("Paris");
        toTextInput.sendKeys("New York");

//        WebElement toCharlesDeGaulle =  driver.findElement(By.xpath("//span[@data-testid='airport-name' and contains(.,'Gaulle')]"));
        WebElement toCharlesDeGaulle =  driver.findElement(By.xpath("//span[@data-testid='airport-name']"));
        toCharlesDeGaulle.click();

        WebElement datePickerInput = driver.findElement(By.xpath("//input[@id='when']"));
        datePickerInput.click();

        WebElement datePicker = driver.findElement(By.xpath("//button[@data-testid='12-12-2025']"));
        datePicker.click();

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






    }





}
