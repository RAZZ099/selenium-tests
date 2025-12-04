package scoalaInformala.ghostpom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavHeaderPage {

    private final WebDriver driver;

    public NavHeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[span[text()=\"Resources\"]]")
    public WebElement resourcesButton;

    @FindBy(xpath = "//p[contains(text(),\"Start here \")]")
    public WebElement startHereButton;

    @FindBy(id = "search-input")
    public WebElement searchInput;

    @FindBy(xpath = "//li[@class=\"ais-Hits-item search-result-item\"][10]")
    public WebElement tenthResult;

    @FindBy(xpath = "//a[contains(text(),\"Pricing\")]")
    public WebElement pricingButton;

    @FindBy(id = "members")
    public WebElement membersSlider;

    public void setMembersSlider(int value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const slider = arguments[0];"
                + "slider.value = arguments[1];"
                + "slider.dispatchEvent(new Event('input', { bubbles : true}));"
                + "slider.dispatchEvent(new Event('change', { bubbles: true}));", membersSlider, value);
    }
}
