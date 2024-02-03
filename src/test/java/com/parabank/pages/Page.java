package com.parabank.pages;

import com.parabank.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    WebDriver driver; //driver variable
    WebDriverWait wait; //wait variable

    //Creation of constructor with parameters of the abstract class
    public Page(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(this.driver, Duration.ofSeconds(General.WAIT_TIME)); //Explicit Wait
    }

    //Abstract method for which will be defined in BasePage class for page title
    public abstract String getPageTitle();

    //Abstract method for which will be defined in BasePage for single element
    public abstract WebElement getWebElement(By locator);

    //Abstract method for which will be defined in BasePage for list of elements
    public abstract List<WebElement> getWebElements(By locator);

    //Explicit wait
    public abstract void waitForWebElement(By locator);


    //Abstract method with wild card BasePage for Instances
    public <T extends BasePage> T getInstance(Class<T> tClass){
        try {
            return tClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
