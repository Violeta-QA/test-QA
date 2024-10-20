package projectElectroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage{
    WebDriverWait wait;
    WebDriver driver;

    public ContactPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
        this.wait = wait;
        this.driver = driver;
    }

    By firstNameTxt = By.cssSelector("input#wpforms-5460-field_0");
    By lastNameTxt = By.cssSelector("input#wpforms-5460-field_0-last");
    By emailTxt = By.cssSelector("input#wpforms-5460-field_1");
    By messageTxt = By.cssSelector("textarea#wpforms-5460-field_2");
    By sentMessageBtn = By.cssSelector("button#wpforms-submit-5460");
    By confirmationMessageTxt = By.cssSelector("div#wpforms-confirmation-5460 > p");
    By inlineValidationErrorMsg = By.cssSelector("label.wpforms-error");

    public void enterFirstName(String firstName) throws Exception {
        WebElement firstNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameTxt));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameElement);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameTxt)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameTxt)).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailTxt)).sendKeys(email);
    }

    public void enterCommentMessage(String message) {
        wait.until(ExpectedConditions.elementToBeClickable(messageTxt)).sendKeys(message);
    }

    public void clickOnSendMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(sentMessageBtn)).click();
    }

    public void sendMessage(String firstName, String lastName, String email, String message) throws Exception {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterCommentMessage(message);
        clickOnSendMessage();
    }

    public void sendMessageWithoutEmail(String firstName, String lastName, String message) throws Exception {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCommentMessage(message);
        clickOnSendMessage();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageTxt));
        return driver.findElement(confirmationMessageTxt).getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inlineValidationErrorMsg));
        return driver.findElement(inlineValidationErrorMsg).getText();
    }
}
