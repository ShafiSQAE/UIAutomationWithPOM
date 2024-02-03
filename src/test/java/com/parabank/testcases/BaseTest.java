package com.parabank.testcases;

import com.parabank.pages.BasePage;
import com.parabank.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    Page page;

    private Properties properties;


    //this block of code/constructor is written to read data from config.properties file
    public BaseTest() {    //constructor name
        try {
            String filepath = System.getProperty("user.dir")+"/src/test/resources/config.properties"; //dynamic path of config.prperties file
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(filepath); //will read data from config file
            properties.load(fileInputStream); //will load properties from config file in RAM
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @BeforeMethod
    public void setUpBrowser(){
        String  browserName= properties.getProperty("browserName");

        if(Objects.equals(browserName, "chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if(Objects.equals(browserName, "firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if(Objects.equals(browserName, "chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver= new ChromeDriver(options);
        } else if(Objects.equals(browserName, "firefoxHeadless")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options= new FirefoxOptions();
            options.addArguments("--headless");
            driver=new FirefoxDriver(options);
        }else
            System.out.println("Provide Browser Name ");



        //driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();

        page= new BasePage(driver);
    }


    public String getUsername(){
        return properties.getProperty("username");
    } //will read username from config file

    public String getPassword(){
        return properties.getProperty("password");
    } //will read password from config file


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
