package projectElectroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriverWait wait;

    public HomePage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
        this.wait = wait;
    }

    By trendingStyleMenuLink = By.cssSelector("li#menu-item-5345");


    public void clickOnTrendingStyles() {
        wait.until(ExpectedConditions.elementToBeClickable(trendingStyleMenuLink)).click();
    }
}
