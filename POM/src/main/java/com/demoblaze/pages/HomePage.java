package com.demoblaze.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
//private By signin = By.id("signin2");
  //  private By home = By.id("navbarExample");
   // private By Cart = By.id("cartur");
    //private By logIn = By.id("login2");
    private By signUp = By.id("signin2");
    //private By previous = By.id("contcar");
    private By userName = By.id("sign-username");
    private By password = By.id("sign-password");
    private By SignUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");


    public void clickSignUp(){
find(signUp).click();
    }
    public void setUserName(String USERNAME){
        set(userName,USERNAME);
    }
    public void setPassword(String passwords){
        set(password,passwords);
    }
    public void clickSignupButton(){
        click(SignUpButton);
    }
}
