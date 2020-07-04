package features;

import browserLaunch.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.Path;
import utility.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;


public class CashIn extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public CashIn() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xpathForCashINURL)
    public  WebElement cashInMenuHit;

    @FindBy(id = "toAc")
    public  WebElement toAcc;

    @FindBy(id = "amount")
    public  WebElement amount;

    @FindBy(id = "deposit")
    public  WebElement depositButton;

    @FindBy(id = "confirm")
    public  WebElement confirmButton;

    @FindBy(xpath = Path.xPathCashIn1)
    public  WebElement xPathForCashIn1;

    @FindBy(xpath = Path.xPathForStoreTxnId)
    public  WebElement storeTxnID;

    @FindBy(xpath = Path.xPathForStoreToWallet)
    public  WebElement storeWallet;

    @FindBy(xpath = Path.xPathForStoreAmount)
    public  WebElement storeAmount;

    @FindBy(xpath = Path.xPathForDailyLimitExceedMsg)
    public  WebElement dailyLimit;


    @Test(priority = 1)
    public void testCashInURL() throws InterruptedException, IOException, URISyntaxException {
        cashInMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testToAcc() throws InterruptedException, IOException, URISyntaxException {
        toAcc.sendKeys(Util.readConfigData()[4]);
        Thread.sleep(2000);

    }
    @Test(priority =3 )
    public void testAmount() throws InterruptedException, IOException, URISyntaxException {
        amount.sendKeys(Util.readConfigData()[5]);
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =4 )
    public void testCashInButton() throws InterruptedException, IOException, URISyntaxException {
        depositButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =5 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        confirmButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }



}