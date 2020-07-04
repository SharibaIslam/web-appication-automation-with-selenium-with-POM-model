package testCases;

import features.CashIn;
import features.Payment;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestPaymentPage {
    Payment payment;
    Date time = new Date(System.currentTimeMillis());
    WebElement ee1,ee2,ee3;
    String txnId,toWallet,amount,ascm2;
    @BeforeTest
    public void init() throws Exception {
        payment = new Payment();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testLaunchBrowser() throws IOException, InterruptedException, URISyntaxException {
        payment.testPaymentURL();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testUserName() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.billerCode.isDisplayed(), "Login test PASS");
        payment.testToMerchant();
    }
    @Test(priority = 3,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testPaymentButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.paymentButton.isDisplayed(), "Login test PASS");
        payment.testToPaymentButton();
    }
    @Test(priority = 4,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testFromAcc() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.fromAcc.isDisplayed(), "Login test PASS");
        payment.testFrommAcc();
    }
    @Test(priority = 5,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testUserPIN() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.amount.isDisplayed(), "Login test PASS");
        payment.testAmount();
    }
    @Test(priority = 6,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testDepositButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.depositButton.isDisplayed(), "Login test PASS");
        payment.testCashInButton();
    }
    @Test(priority = 7,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(payment.confirmButton.isDisplayed(), "Login test PASS");
        payment.testConfirmButton();
    }

    @Test(priority = 8,alwaysRun = true, groups = "TestPaymentPage",dependsOnGroups = "TestLoginPage")
    public void paymentTestCase() throws Exception,IOException, InterruptedException, URISyntaxException  {
        try {
            WebElement asucpayment = payment.xPathForPaymentMsg;
            String ascpay=asucpayment.getText();
            System.out.println(ascpay);
            String ascmpay="Transaction successful.";
            //txn id store
            ee1= payment.storeTxnID;
            txnId=ee1.getText();
            System.out.println(txnId);
            //To wallet store
            ee2=payment.storeWallet;
            toWallet=ee2.getText();
            System.out.println(toWallet);
            //Amount store
            ee3= payment.storeAmount;
            amount=ee3.getText();
            System.out.println(amount);

            if(ascpay.equals(ascmpay))
            {
                Allure.addDescription("Status: PASS \n\r Type: Payment \n\r DateTime: " +(time.toString())+
                        "\n\r From Wallet: " +Util.readConfigData()[2]+ "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }

            else
            {
                Assert.fail("Status: FAIL \n\r Type: Payment \n\r DateTime: " +(time.toString())+
                        "\n\r From Wallet: " +Util.readConfigData()[2]+ "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }
        }catch(Exception e) {
            Assert.fail("Status: FAIL \n\r Type: Payment is failed for Internal Error \n\r DateTime: " +(time.toString())+
                    "\n\r From Wallet: " +Util.readConfigData()[2]+ "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
        }


    }



}
