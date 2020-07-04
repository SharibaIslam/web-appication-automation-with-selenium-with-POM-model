package testCases;

import features.CashIn;
import features.CashOut;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestCashOutPage {
    CashOut cashOut=new CashOut();
    Date time = new Date(System.currentTimeMillis());
    WebElement ee1,ee2,ee3;
    String txnId,toWallet,amount;

    public TestCashOutPage() throws Exception {
    }

    @BeforeTest
    public void init() throws Exception {
        cashOut = new CashOut();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testLauchBrowser() throws IOException, InterruptedException, URISyntaxException {
        cashOut.testCashOutURL();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testUserName() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashOut.customerWallet.isDisplayed(), "Login test PASS");
        cashOut.testToAcc();
    }
    @Test(priority = 3,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testUserPIN() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashOut.amount.isDisplayed(), "Login test PASS");
        cashOut.testAmount();
    }
    @Test(priority = 4,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testWithdrawButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashOut.withdrawButton.isDisplayed(), "Login test PASS");
        cashOut.testCashOutButton();
    }
    @Test(priority = 5,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(cashOut.confirmButton.isDisplayed(), "Login test PASS");
        cashOut.testConfirmButton();
    }

    @Test(priority = 6,alwaysRun = true, groups = "TestCashOutPage",dependsOnGroups = "TestCashInPage")
    public void testCaseForCashIn() throws IOException, InterruptedException, URISyntaxException {
        try {
            WebElement asuc = cashOut.xPathForCashOutmsg;
            String asc=asuc.getText();
            String ascm="Transaction successful.";
            //txn id store
            ee1= cashOut.storeTxnID;
            txnId=ee1.getText();
            System.out.println(txnId);
            //To wallet store
            ee2= cashOut.storeWallet;
            toWallet=ee2.getText();
            System.out.println(toWallet);
            //Amount store
            ee3= cashOut.storeAmount;
            amount=ee3.getText();
            System.out.println(amount);

            if(asc.equals(ascm))
            {
                Allure.addDescription("Status: PASS \n\r Type: Customer Cash-Out \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " + Util.readConfigData()[2] + "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }

            else
            {
                Assert.fail("Status: FAIL \n\r Type: Customer Cash-Out \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " +Util.readConfigData()[2]+ "\n\r To Wallet: " +toWallet+  "\n\r Amount: " +amount+ "\n\r Txn ID: " +txnId );
            }

        }catch(Exception e)	{

            String ascm2="Transaction failed! Reason: DAILY_NO_OF_TXN_LIMIT_EXCEEDED";
            String msg=cashOut.dailyLimit.getText();

            if(msg.equals(ascm2))
            {
                Allure.addDescription("Status: PASS \n\r Type: Daily Limit Exceed \n\r DateTime: " +(time.toString()));
            }
            else {
                Assert.fail("Status: FAIL \n\r Type: Customer Cash-Out Failed For Internal Error \n\r DateTime: " + (time.toString()) + "\n\r From Wallet: " + Util.readConfigData()[2] + "\n\r To Wallet: " + toWallet + "\n\r Amount: " + amount + "\n\r Txn ID: " + txnId);
            }
        }

    }



}
