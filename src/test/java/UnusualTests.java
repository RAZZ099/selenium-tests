import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnusualTests {

    public void cookiesTest (){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kostal-solar-portal.com");
    }
}
