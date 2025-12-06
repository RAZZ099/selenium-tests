package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="search-input")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@class='ais-Hits-item search-result-item'][10]")
    private WebElement tenthResult;

    public void search(String text){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(text);
    }
    public void clicktenthResult(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tenthResult));
        tenthResult.click();
    }

}
