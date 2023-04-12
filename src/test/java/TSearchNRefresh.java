import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TSearchNRefresh {

    @Test
    public void TScenario(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        openAndRefresh(driver);
        clickOnSearch(driver);
        driver.quit();
    }
    public void openAndRefresh(ChromeDriver driver){
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle()+ " has been opened");
    }
    public void clickOnSearch(ChromeDriver driver){
        WebElement searchField = driver.findElement(By.cssSelector("input[id=search]"));
        searchField.sendKeys(Keys.ENTER);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click()", searchField);
       // Assert.assertTrue(ExpectedConditions.titleContains("youtube").apply(driver).booleanValue());
    }
}
