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


public class Payment extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public Payment() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xPathForPayment)
    public  WebElement paymentMenuHit;

    @FindBy(id = "merchant")
    public  WebElement billerCode;

    @FindBy(xpath = Path.xPathForPayment1)
    public  WebElement paymentButton;

    @FindBy(id = "paymentFromAc")
    public  WebElement fromAcc;

    @FindBy(id = "amount")
    public  WebElement amount;

    @FindBy(id = "deposit")
    public  WebElement depositButton;

    @FindBy(id = "confirm")
    public  WebElement confirmButton;

    @FindBy(xpath = Path.xPathForPayment2)
    public  WebElement xPathForPaymentMsg;

    @FindBy(xpath = Path.xPathForStoreTxnId)
    public  WebElement storeTxnID;

    @FindBy(xpath = Path.xPathForStoreToWallet)
    public  WebElement storeWallet;

    @FindBy(xpath = Path.xPathForStoreAmount)
    public  WebElement storeAmount;

    @FindBy(xpath = Path.xPathForDailyLimitExceedMsg)
    public  WebElement dailyLimit;


    @Test(priority = 1)
    public void testPaymentURL() throws InterruptedException, IOException, URISyntaxException {
        paymentMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testToMerchant() throws InterruptedException, IOException, URISyntaxException {
        billerCode.sendKeys(Util.readConfigData()[7]);
        Thread.sleep(2000);
    }

    @Test(priority =3 )
    public void testToPaymentButton() throws InterruptedException, IOException, URISyntaxException {
        paymentButton.click();
        Thread.sleep(2000);

    }

    @Test(priority =4 )
    public void testFrommAcc() throws InterruptedException, IOException, URISyntaxException {
        fromAcc.sendKeys(Util.readConfigData()[8]);
        Thread.sleep(2000);
    }
    @Test(priority =5)
    public void testAmount() throws InterruptedException, IOException, URISyntaxException {
        amount.sendKeys(Util.readConfigData()[5]);
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =6 )
    public void testCashInButton() throws InterruptedException, IOException, URISyntaxException {
        depositButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =7 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        confirmButton.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }



}