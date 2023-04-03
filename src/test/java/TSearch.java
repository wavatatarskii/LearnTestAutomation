import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
    import org.testng.internal.Configuration;

import java.io.File;

public class TSearch {
    @Test
    public void openWebDEinChromeTest(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://web.de/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
