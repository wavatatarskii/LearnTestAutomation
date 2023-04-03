import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TSearchNRefresh {

    @Test
    public void openAndRefresh(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
