package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page{
    // constructor of the class BasePage
    public BasePage(WebDriver driver) {

        super(driver);
    }

    // method for getting pageTitle of Every page
    @Override
    public String getPageTitle() {

        return driver.getTitle();
    }


    //method for  locating single element (identifier: public, return type: WebElement, Name: getWebelement, parameter: By locator
    // WebElement in staring should be null
    //use try catch for error handling
    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement=null;
        try {
            waitForWebElement(locator);  //wait for element to be ready
            webElement=driver.findElement(locator);
        } catch (Exception exception) {
            System.out.println(locator.toString()+" not found");
        }
        return webElement;
    }

    //method for  locating multiple elements (identifier: public, return type: List<WebElements>, Name: getWebelements, parameter: By locator
    // WebElements list in staring should be null
    //use try catch for error handling
    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements=null;
        try {
            waitForWebElement(locator);
            webElements=driver.findElements(locator);
        } catch (Exception exception){
            System.out.println(locator.toString()+ "  not found");
        }
        return webElements;
    }


    //Defining wait
    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception exception){
            System.out.println(locator.toString()+ " is not loading");
        }

    }
}
