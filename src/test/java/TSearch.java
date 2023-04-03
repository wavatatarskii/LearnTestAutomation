import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class TSearch {
    @Test
    public void openGoogleComInChromeTest(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.com.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
