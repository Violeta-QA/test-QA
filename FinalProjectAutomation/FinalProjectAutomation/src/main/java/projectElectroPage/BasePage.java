package projectElectroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriverWait wait;
    WebDriver driver;

    public BasePage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    By electroLogo = By.cssSelector("a.header-logo-link");
    By contactLink = By.cssSelector("li#menu-item-5397 > a");

    public void clickOnLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(electroLogo)).click();
    }

    public void clickContact() throws Exception {
        WebElement contactElement = wait.until(ExpectedConditions.presenceOfElementLocated(contactLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactElement);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }
}
