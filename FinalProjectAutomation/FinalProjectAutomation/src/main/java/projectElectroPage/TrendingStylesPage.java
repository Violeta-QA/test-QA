package projectElectroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class TrendingStylesPage {
    WebDriverWait wait;
    WebDriver driver;

    public TrendingStylesPage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    By purpleSoloWirelles = By.xpath("//h2[text()=\"White Solo 2 Wireless\"]");
    By addProductToWishlist = By.xpath("//a[@data-product-id=\"2718\"]/span[text()=\"Wishlist\"]");
    By productAdded = By.cssSelector("div#yith-wcwl-message");
    By wishlistIcon = By.cssSelector("div[data-bs-title=\"Wishlist\"] > a");

    public void addHeadphonesToWishlist() throws InterruptedException {
        WebElement purpleSoloWirellesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(purpleSoloWirelles));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", purpleSoloWirellesElement);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(purpleSoloWirellesElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addProductToWishlist)).click();
    }

    public String verifyProductIsAddedToWishlist() {
        WebElement wishlistTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(productAdded));
        return wishlistTxt.getText();
    }

    public void clickOnWishlist() throws Exception{
        WebElement wishlistElement = wait.until(ExpectedConditions.presenceOfElementLocated(wishlistIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishlistElement);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(wishlistIcon)).click();
    }
}
