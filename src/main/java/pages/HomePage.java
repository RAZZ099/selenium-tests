package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final String PAGE_URL = "https://ghost.org/";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage open() {
        navigateTo(PAGE_URL);
        return this;
    }
}
