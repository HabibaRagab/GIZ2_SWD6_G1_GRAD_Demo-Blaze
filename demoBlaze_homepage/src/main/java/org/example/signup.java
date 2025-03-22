package Package1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;

//public class SignUpTest
public class signup {

WebDriver driver ;
private WebDriverWait wait;

    @BeforeTest
    public void setUp() {

        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test
    public void testSignUp() {
        // Click on Sign Up button to open the form
        driver.findElement(By.id("signin2")).click();

        // Wait for the sign-up modal to appear
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));

        // Generate random username and password
        String randomUsername = "user1235" + new Random().nextInt(1000);
        String randomPassword = "pass123456";

        // Enter username and password
        driver.findElement(By.id("sign-username")).sendKeys(randomUsername);
        driver.findElement(By.id("sign-password")).sendKeys(randomPassword);

        // Click the Sign Up button
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        // Wait for and verify alert pop-up
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Sign up successful.", "Sign up message mismatch!");

        // Accept the alert
        driver.switchTo().alert().accept();
    }
    // Invalid scenarios
    @Test
    public void testSignUpWithEmptyFields() {
        driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password."), "Empty fields error message not displayed!");
        driver.switchTo().alert().accept();
    }

    @Test
    public void testSignUpWithExistingUser() {
        driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        driver.findElement(By.id("sign-username")).sendKeys("israak8");
        driver.findElement(By.id("sign-password")).sendKeys("1");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("This user already exist."), "Existing user error message not displayed!");
        driver.switchTo().alert().accept();
    }

    @Test
    public void testSignUpWithShortPassword() {
        driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        driver.findElement(By.id("sign-username")).sendKeys("userTestt");
        driver.findElement(By.id("sign-password")).sendKeys("1");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Password too short"), "Short password error message not displayed!");
        driver.switchTo().alert().accept();
    }
    @Test
    public void testSignUpWithShortUsername() {
        driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        driver.findElement(By.id("sign-username")).sendKeys("er");
        driver.findElement(By.id("sign-password")).sendKeys("1");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Username is too short"), "Short username error message not displayed!");
        driver.switchTo().alert().accept();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}




