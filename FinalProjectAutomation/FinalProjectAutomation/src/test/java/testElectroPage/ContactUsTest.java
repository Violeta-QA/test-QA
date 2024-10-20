package testElectroPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projectElectroPage.ContactPage;

import java.time.Duration;

public class ContactUsTest {
    WebDriver driver;
    WebDriverWait wait;
    ContactPage contactPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        contactPage = new ContactPage(wait, driver);
        driver.manage().window().maximize();
        driver.get("https://electro.madrasthemes.com/");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void verifyMessageCanBeSent()throws Exception{
        contactPage.clickContact();
        contactPage.sendMessage(
                "Violeta",
                "Manevska",
                "violetamanevska@brainster.com",
                "This is a test.");
        Assert.assertEquals(contactPage.getConfirmationMessage(),
                "Thanks for contacting us! We will be in touch with you shortly.");
    }
    @Test
    public void verifyMessageCanNotBeSentwithoutEmail()throws Exception{
        contactPage.clickContact();
        contactPage.sendMessageWithoutEmail(
                "Violeta",
                "Manevska",
                "This is a test.");
        Assert.assertEquals(contactPage.getErrorMessage(), "This field is required.");
    }
}
