package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage {
    WebDriver driver;

    public PricingPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Pricing']")
    private WebElement pricingButton;

    public void hoverAndClickPricing(){
        Actions actions = new Actions(driver);
        actions.moveToElement(pricingButton).perform();
        pricingButton.click();
    }
}
