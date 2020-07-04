package browserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class BrowserOpening {

    public static WebDriver driver;
    public static BrowserOpening instance;

    private BrowserOpening() {
        setUp();
    }

    public static BrowserOpening getInstance() throws Exception, ArrayIndexOutOfBoundsException, IndexOutOfBoundsException, IOException, InterruptedException {
        if (instance == null) {
            instance = new BrowserOpening();
        }
        return instance;
    }
    private void setUp(){
        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "./geckodriver.exe");
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
