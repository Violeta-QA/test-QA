package testElectroPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projectElectroPage.ContactPage;
import projectElectroPage.HomePage;
import projectElectroPage.TrendingStylesPage;
import projectElectroPage.WishlistPage;

import java.time.Duration;

public class testElectroPage {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    TrendingStylesPage trendingStylesPage;
    WishlistPage wishlistPage;
    ContactPage contactPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage = new HomePage(wait, driver);
        trendingStylesPage = new TrendingStylesPage(wait, driver);
        wishlistPage = new WishlistPage(wait, driver);
        contactPage = new ContactPage(wait, driver);
        driver.manage().window().maximize();
        driver.get("https://electro.madrasthemes.com/");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void electroFinalProjectTest() throws Exception {

        homePage.clickOnTrendingStyles();

        trendingStylesPage.addHeadphonesToWishlist();
        Assert.assertEquals(trendingStylesPage.verifyProductIsAddedToWishlist(), "Product added!");

        trendingStylesPage.clickOnWishlist();
        Assert.assertEquals(wishlistPage.getProductName(), "White Solo 2 Wireless");

        wishlistPage.clickOnLogo();
        Assert.assertEquals(driver.getTitle(), "Electro – Electronics Store WooCommerce Theme");

        wishlistPage.clickContact();
        Assert.assertTrue(driver.getTitle().contains("Contact"));
        contactPage.sendMessage(
                "Violeta",
                "Manevska",
                "violetamanevska@brainster.com",
                "This is test.");
        Assert.assertEquals(contactPage.getConfirmationMessage(),
                "Thanks for contacting us! We will be in touch with you shortly.");
    }
}
