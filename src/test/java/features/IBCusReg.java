package features;

import browserLaunch.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility.Path;
import utility.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;


public class IBCusReg extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public IBCusReg() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xPathForIntraCusReg)
    public  WebElement cusRegMenuHit;

    @FindBy(name = "nationalIdNumber")
    public  WebElement NID;

    @FindBy(xpath = Path.xPathForIntraCusReg1)
    public  WebElement xPathForIntraCusReg1;

    @FindBy(name = "bankName")
    public  WebElement bankName;

    @FindBy(name = "fullName")
    public  WebElement fullName;

    @FindBy(name = "mobilePhone")
    public  WebElement mobilePhone;

    @FindBy(id = "register")
    public  WebElement registerButton;

    @FindBy(id = "confirm")
    public  WebElement confirmButton;

    @FindBy(xpath = Path.xPathForIntraCusReg2)
    public  WebElement xPathForIntraCusReg2;

    @FindBy(xpath = Path.xPathForStoreIntraCusRegNAme)
    public  WebElement nameStore;

    @FindBy(xpath = Path.xPathForStoreIntraCusRegWallet)
    public  WebElement storeWallet;


    @Test(priority = 1)
    public void testIntraRegURL() throws InterruptedException, IOException, URISyntaxException {
        cusRegMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testNID() throws InterruptedException, IOException, URISyntaxException {
        NID.sendKeys(Util.readConfigData()[10]);
        Thread.sleep(4000);

    }
    @Test(priority =3 )
    public void testOpenClick() throws InterruptedException, IOException, URISyntaxException {
        xPathForIntraCusReg1.click();
        Thread.sleep(2000);

    }
    @Test(priority =4 )
    public void testBank() throws InterruptedException, IOException, URISyntaxException {
        Select ibank = new Select(bankName);
        Thread.sleep(2000);
        ibank.selectByIndex(2);
        Thread.sleep(2000);

    }
    @Test(priority =5 )
    public void testName() throws InterruptedException, IOException, URISyntaxException {
        fullName.sendKeys(Util.readConfigData()[11]);
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =6 )
    public void testMob() throws InterruptedException, IOException, URISyntaxException {
        mobilePhone.sendKeys(Util.readConfigData()[12]);
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =7 )
    public void testRegisterButton() throws InterruptedException, IOException, URISyntaxException {
        registerButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =8 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        confirmButton.click();
        Thread.sleep(2000);
        Util.PushForIntraCusReg();
        Thread.sleep(4000);
        Util.attachScreenShot(driver);


    }



}