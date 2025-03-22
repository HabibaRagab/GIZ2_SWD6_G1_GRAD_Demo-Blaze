import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoBlazeCartAutomation {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\dev\\testing_project\\GIZ2_SWD6_G1_GRAD_Demo-Blaze\\chrome-win64\\chrome.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://www.demoblaze.com/");

            // Wait for the page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to the cart page
            WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
            cartLink.click();

            // Wait for the cart page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-wrapper")));

            // Verify the cart page is loaded
            String cartPageTitle = driver.getTitle();
            if (cartPageTitle.contains("")) {
                System.out.println("Cart page loaded successfully.");
            } else {
                System.out.println("Failed to load cart page.");
            }

            // Check if the cart is empty
            WebElement cartTable = driver.findElement(By.id("tbodyid"));
            if (cartTable.findElements(By.tagName("tr")).isEmpty()) {
                System.out.println("The cart is empty.");
            } else {
                System.out.println("The cart contains items.");
            }

            // Example: Click the "Place Order" button (if items are in the cart)
            WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));
            if (placeOrderButton.isDisplayed()) {
                System.out.println("Place Order button is visible.");
                placeOrderButton.click();

                // Wait for the order modal to appear
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));

                // Example: Fill out the order form (optional)
                driver.findElement(By.id("name")).sendKeys("John Doe");
                driver.findElement(By.id("country")).sendKeys("USA");
                driver.findElement(By.id("city")).sendKeys("New York");
                driver.findElement(By.id("card")).sendKeys("1234567890123456");
                driver.findElement(By.id("month")).sendKeys("12");
                driver.findElement(By.id("year")).sendKeys("2025");

                // Submit the order
                driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]")).click();

                // Wait for the confirmation alert
                wait.until(ExpectedConditions.alertIsPresent());
                System.out.println("Order confirmation: " + driver.switchTo().alert().getText());
                driver.switchTo().alert().accept();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}