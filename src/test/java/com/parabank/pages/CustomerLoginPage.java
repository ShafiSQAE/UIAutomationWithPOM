package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage extends BasePage{


    //Constructor
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    //Method for filling username in Customer Login Page
    //Return type should be the page name where it redirects (the same page because filling name doesn't take us another page)
    //fillUsername is the method name and parameter is String type and username is the name of the param)
    //if action does not redirect to another page then return this is used.
    public CustomerLoginPage fillUsername(String username){
        WebElement webElement = getWebElement(By.name("username")); //locating element by won declared method
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    //Method for filling password in Customer Login Page
    //Return type should be the page name where it redirects (the same page because filling password doesn't take us another page)
    //fillPassword is the method name and parameter is String type and password is the name of the param)
    //if action does not redirect to another page then return this is used.
    public CustomerLoginPage fillPassword(String password){
        WebElement webElement = getWebElement(By.name("password")); //locating element
        webElement.clear();
        webElement.sendKeys(password);
        return this;
    }

    //Method for clicking on login button in Customer Login Page
    //Return type should be the page name where it redirects (Clicking on the button takes us to Homepage)
    //fillPassword is the method name and parameter is String type and password is the name of the param)
    //if action does not redirect to another page then return getInstance(PageName.class)

    public HomePage clickLoginButton(){
        getWebElement(By.cssSelector("input.button")).click();
        return getInstance(HomePage.class);
    }  //Successful Login

    public CustomerLoginPage clickLoginButtonToFail(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }  //Not Successful Login or Error message show


    public CustomerLoginPage doLogin(){
        return clickLoginButtonToFail();
    }


    public CustomerLoginPage doLogin (String username) {
        return fillUsername(username)
                .clickLoginButtonToFail();
    }

    public HomePage doLogin (String username, String password){

        return fillUsername(username)
                .fillPassword(password)
                .clickLoginButton();
    }

    public boolean hasError(){
        return getWebElements(By.className("error")).size() > 0;
    }



}
