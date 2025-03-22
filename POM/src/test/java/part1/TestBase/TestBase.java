package part1.TestBase;

import com.demoblaze.pages.BasePage;
import com.demoblaze.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
   protected WebDriver driver;
   protected BasePage basePage;
   protected HomePage homePage;
   private String url= "https://www.demoblaze.com/index.html";
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage=new BasePage();
        homePage=new HomePage();
        basePage.setDriver(driver);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
