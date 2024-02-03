package com.parabank.pages;

import com.parabank.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage{

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectAccountType(int index){
        General.waitForStable();
        new Select(getWebElement(By.id("type"))).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage clickOpenNewAccount(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    public boolean hasAccountNumber(){
        return getWebElements(By.id("newAccountId")).size() > 0;
    }


}
