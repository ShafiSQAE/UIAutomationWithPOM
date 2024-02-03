package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.FundTransferPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  FundTransferTest extends  BaseTest{

    @Test
    public void fundTransferShouldSucceeded(){
        FundTransferPage fundTransferPage=  page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(),getPassword())
                .clickFundTransferLink()
                .fillAmount(4000.00)
                .clickTransferButton();
        Assert.assertTrue(fundTransferPage.hasTransferCompleteNotification());
    }
}
