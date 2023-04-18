package com.olaptev.testwselenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class TSearch {
    protected WebDriver driver;
    protected String url;
    @BeforeClass
    public void setDriver(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        /**
         * Switching options for Firefox and IE drivers
         */
//        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        url = "https://www.youtube.com/";
        openAndRefresh(driver,url);
        driver.manage().window().fullscreen();
    }
    /**
     * Helping method to open and refresh a website
     */
    public void openAndRefresh(WebDriver driver, String url){
        driver.navigate().to(url);
        driver.navigate().refresh();
        System.out.println(driver.getTitle()+ " has been opened");
    }
    /**
     * Helping function to abstract clicking on element and have an option to rewrite original ChromeDriver method
     * in case the website rendered bad and locator isn't interceptable
     */
    public void clickOnElement(WebElement element){
        element.click();
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click()", searchField);
        // Assert.assertTrue(ExpectedConditions.titleContains("youtube").apply(driver).booleanValue());
    }
    @AfterClass
    public void tearTestDown(){
        driver.quit();
    }
}
