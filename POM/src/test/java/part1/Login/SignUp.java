package part1.Login;

import com.demoblaze.pages.HomePage;
import org.testng.annotations.Test;
import part1.TestBase.TestBase;

public class SignUp extends TestBase {
    @Test
    public void testLoginErrorMessage(){
homePage.clickSignUp();
homePage.setUserName("kamsdmakd");
homePage.setPassword("akdmwkdm");
homePage.clickSignupButton();
    }
}
