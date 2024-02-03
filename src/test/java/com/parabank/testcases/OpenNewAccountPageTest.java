package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.pages.OpenNewAccountPage;
import com.parabank.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountPageTest extends BaseTest{

    @Test (enabled = false)
    public void accountOpenShouldSucceeded(){
        CustomerLoginPage customerLoginPage = page.getInstance(CustomerLoginPage.class);

        Assert.assertEquals(customerLoginPage.getPageTitle(), ParaBankString.LOGIN_TITLE);

        HomePage homePage=  customerLoginPage
                .doLogin(getUsername(),getPassword());

        Assert.assertTrue(homePage.hasLogoutLink());

        OpenNewAccountPage openNewAccountPage =  homePage
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenNewAccount();

        Assert.assertTrue(openNewAccountPage.hasAccountNumber());

    }

    @Test
    public void accountOpenShouldSucceeded2(){
        OpenNewAccountPage openNewAccountPage = page.getInstance(CustomerLoginPage.class)
                        .doLogin(getUsername(),getPassword())
                                .clickOpenNewAccountLink()
                                        .selectAccountType(1)
                                                .clickOpenNewAccount();


        Assert.assertTrue(openNewAccountPage.hasAccountNumber());

    }
}

