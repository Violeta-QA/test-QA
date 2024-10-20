package projectElectroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage {
    WebDriverWait wait;
    WebDriver driver;

    public WishlistPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
        this.wait = wait;
        this.driver = driver;
    }
    By productInWishlist = By.cssSelector("td.product-name >a");
    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productInWishlist));
        return driver.findElement(productInWishlist).getText();
    }
}

