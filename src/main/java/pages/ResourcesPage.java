package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResourcesPage extends BasePage{


    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchImput;

    @FindBy(xpath = "//li[@class='ais-Hits-item search-result-item'][10]")
    private WebElement tenthSearchResult;

    private By tenthSearchResultBy = By.xpath("//li[@class='ais-Hits-item search-result-item'][10]");

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

    public ResourcesPage searchFor(String query){
        searchImput.sendKeys(query);
        return this;
    }

    public BlogPage clickTenthSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenthSearchResult));
        tenthSearchResult.click();
        return new BlogPage(driver);

    }


}
