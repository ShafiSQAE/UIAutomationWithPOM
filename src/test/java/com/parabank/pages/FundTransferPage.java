package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferPage extends BasePage{
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    public FundTransferPage fillAmount(double amount){
        General.waitForStable();
        getWebElement(By.id("amount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public FundTransferPage clickTransferButton(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    public boolean hasTransferCompleteNotification(){
        General.waitForStable();
       return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.TRANSFER_COMPLETE_NOTIFICATION);
    }
}
