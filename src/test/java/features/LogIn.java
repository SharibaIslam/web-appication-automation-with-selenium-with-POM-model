package features;

import browserLaunch.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.*;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;


public class LogIn extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public LogIn() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public  WebElement userName;

    @FindBy(id = "password")
    public  WebElement userPIN;

    @FindBy(id = "remember")
    public  WebElement chkRememberButton;

    @FindBy(id = "confirm")
    public  WebElement confirmButton;

    @Test(priority = 0)
    public void testLaunchBrowser() throws InterruptedException, IOException, URISyntaxException {
        driver.navigate().to(Util.readConfigData()[1]);
        Thread.sleep(2000);

    }
    @Test(priority = 1)
    public void testUserName() throws InterruptedException, IOException, URISyntaxException {
        userName.sendKeys(Util.readConfigData()[2]);
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testPIN() throws InterruptedException, IOException, URISyntaxException {
        userPIN.sendKeys(Util.readConfigData()[3]);
        Thread.sleep(2000);

    }
    @Test(priority =3 )
    public void testRememberChkBox() throws InterruptedException, IOException, URISyntaxException {
        chkRememberButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =3 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        confirmButton.click();
        Thread.sleep(2000);
        Util.PushForLogin();
        Thread.sleep(3000);

    }


}