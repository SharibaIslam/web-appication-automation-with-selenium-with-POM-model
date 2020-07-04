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


public class CashOut extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public CashOut() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xpathForCashOutURL)
    public  WebElement cashOutMenuHit;

    @FindBy(id = "fromAc")
    public  WebElement customerWallet;

    @FindBy(id = "amount")
    public  WebElement amount;

    @FindBy(id = "withdraw")
    public  WebElement withdrawButton;

    @FindBy(id = "confirm")
    public  WebElement confirmButton;

    @FindBy(xpath = Path.xPathCashOut2)
    public  WebElement xPathForCashOutmsg;

    @FindBy(xpath = Path.xPathForStoreTxnId)
    public  WebElement storeTxnID;

    @FindBy(xpath = Path.xPathForStoreToWallet)
    public  WebElement storeWallet;

    @FindBy(xpath = Path.xPathForStoreAmount)
    public  WebElement storeAmount;

    @FindBy(xpath = Path.xPathForDailyLimitExceedMsg)
    public  WebElement dailyLimit;


    @Test(priority = 1)
    public void testCashOutURL() throws InterruptedException, IOException, URISyntaxException {
        cashOutMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testToAcc() throws InterruptedException, IOException, URISyntaxException {
        customerWallet.sendKeys(Util.readConfigData()[6]);
        Thread.sleep(2000);

    }
    @Test(priority =3 )
    public void testAmount() throws InterruptedException, IOException, URISyntaxException {
        amount.sendKeys(Util.readConfigData()[5]);
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =4 )
    public void testCashOutButton() throws InterruptedException, IOException, URISyntaxException {
        withdrawButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =5 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        confirmButton.click();
        Thread.sleep(2000);
        Util.PushForCashOut();
        Thread.sleep(3000);
        Util.attachScreenShot(driver);

    }



}