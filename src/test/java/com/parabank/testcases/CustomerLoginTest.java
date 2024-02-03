package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseTest{
    @Test
    public void loginShouldFailWithoutCredential(){
    CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
            .doLogin();
    Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void verifyLoginPageTitle(){
        CustomerLoginPage customerLoginPage= page.getInstance(CustomerLoginPage.class);
        Assert.assertEquals(customerLoginPage.getPageTitle(), ParaBankString.LOGIN_TITLE);

        //Assert.assertTrue(customerLoginPage.getPageTitle().contains("ParaBank"));
    }

    @Test(enabled = false)
    public void loginShouldFailWithoutPassword(){
        CustomerLoginPage loginPage= page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername());
        Assert.assertTrue(loginPage.hasError());
    }

    @Test(enabled = true)
    public void loginShouldSuccessful(){
        HomePage homePage= page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(homePage.hasLogoutLink());

    }
}
