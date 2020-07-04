package testCases;

import features.CashIn;
import features.LogIn;
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

public class TestCashInPage {
    CashIn cashIn;
    Date time = new Date(System.currentTimeMillis());
    WebElement ee1,ee2,ee3;
    String txnId,toWallet,amount,ascm2;
    @BeforeTest
    public void init() throws Exception {
        cashIn = new CashIn();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testLauchBrowser() throws IOException, InterruptedException, URISyntaxException {
        cashIn.testCashInURL();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testUserName() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashIn.toAcc.isDisplayed(), "Login test PASS");
        cashIn.testToAcc();
    }
    @Test(priority = 3,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testUserPIN() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashIn.amount.isDisplayed(), "Login test PASS");
        cashIn.testAmount();
    }
    @Test(priority = 4,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testDepositButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashIn.depositButton.isDisplayed(), "Login test PASS");
        cashIn.testCashInButton();
    }
    @Test(priority = 5,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashIn.confirmButton.isDisplayed(), "Login test PASS");
        cashIn.testConfirmButton();
    }

    @Test(priority = 6,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testCaseForCashIn() throws IOException, InterruptedException, URISyntaxException {
        try {
            WebElement asuc = cashIn.xPathForCashIn1;
            String asc=asuc.getText();
            String ascm="Transaction successful.";
            //txn id store
            ee1= cashIn.storeTxnID;
            txnId=ee1.getText();
            System.out.println(txnId);
            //To wallet store
            ee2= cashIn.storeWallet;
            toWallet=ee2.getText();
            System.out.println(toWallet);
            //Amount store
            ee3= cashIn.storeAmount;
            amount=ee3.getText();
            System.out.println(amount);

            if(asc.equals(ascm))
            {
                Allure.addDescription("Status: PASS \n\r Type: Customer Cash-In \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " + Util.readConfigData()[2] + "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }

            else
            {
                Assert.fail("Status: FAIL \n\r Type: Customer Cash-In \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " +Util.readConfigData()[2]+ "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }

        }catch(Exception e)	{

            String ascm2="Transaction failed! Reason: DAILY_NO_OF_TXN_LIMIT_EXCEEDED";
            String msg=cashIn.dailyLimit.getText();

            if(msg.equals(ascm2))
            {
                Allure.addDescription("Status: PASS \n\r Type: Daily Limit Exceed \n\r DateTime: " +(time.toString()));
            }
            else {
                Assert.fail("Status: FAIL \n\r Type: Customer Cash-In Failed For Internal Error \n\r DateTime: " + (time.toString()));
            }
        }

    }



}
