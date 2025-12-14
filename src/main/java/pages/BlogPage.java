package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage{

    public BlogPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Pricing']")
    private WebElement pricingButton;

    public PricingPage clickPricing(){
        Actions actions = new Actions(driver);
        actions.moveToElement(pricingButton).perform();
        pricingButton.click();
        return new PricingPage(driver);
    }




}
