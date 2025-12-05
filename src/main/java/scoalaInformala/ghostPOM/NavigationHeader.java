package scoalaInformala.ghostPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigationHeader {

    private final WebDriver driver;

    public NavigationHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[span[text()='Resources']]")
    public WebElement resourcesButton;


    @FindBy(xpath = "//p[contains(text(),'Start here')]")
    public WebElement startHereButton;


    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchInput;


    @FindBy(xpath = "//li[@class='ais-Hits-item search-result-item'][10]")
    public WebElement tenthResult;


    @FindBy(xpath = "//a[text()='Pricing']")
    public WebElement pricingButton;


}