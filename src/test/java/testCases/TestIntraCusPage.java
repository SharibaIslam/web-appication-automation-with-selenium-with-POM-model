package testCases;

import features.CashIn;
import features.IntraBankCusReg;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestIntraCusPage {
    IntraBankCusReg intraBankCusReg;
    Date time = new Date(System.currentTimeMillis());
    WebElement ee1,ee2;
    String txnId,toWallet,amount,name;
    @BeforeTest
    public void init() throws Exception {
        intraBankCusReg = new IntraBankCusReg();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testLauchBrowser() throws IOException, InterruptedException, URISyntaxException {
        intraBankCusReg.testIntraRegURL();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testNID() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.NID.isDisplayed(), "Login test PASS");
        intraBankCusReg.testNID();
    }
    @Test(priority = 3,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testOpenClick() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.xPathForIntraCusReg1.isDisplayed(), "Login test PASS");
        intraBankCusReg.testOpenClick();
    }
    @Test(priority = 4,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testBank() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.bankName.isDisplayed(), "Login test PASS");
        intraBankCusReg.testBank();
    }
    @Test(priority = 5,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testName() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.fullName.isDisplayed(), "Login test PASS");
        intraBankCusReg.testName();
    }
    @Test(priority = 6,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testMobilePhone() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.mobilePhone.isDisplayed(), "Login test PASS");
        intraBankCusReg.testMob();
    }
    @Test(priority = 7,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testRegisterButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.registerButton.isDisplayed(), "Login test PASS");
        intraBankCusReg.testRegisterButton();
    }
    @Test(priority = 8,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(intraBankCusReg.confirmButton.isDisplayed(), "Login test PASS");
        intraBankCusReg.testConfirmButton();
    }

    @Test(priority = 9,alwaysRun = true, groups = "TestIntraCusPage",dependsOnGroups = "TestLoginPage")
    public void testCaseForIntraCusReg() throws IOException, InterruptedException, URISyntaxException {
        try {
            WebElement asuc = intraBankCusReg.xPathForIntraCusReg2;
            String asc=asuc.getText();
            String ascm="Registration is successful.";
            //name store
            ee1= intraBankCusReg.nameStore;
            name=ee1.getText();
            System.out.println(name);
            //To wallet store
            ee2= intraBankCusReg.storeWallet;
            toWallet=ee2.getText();
            System.out.println(toWallet);

            if(asc.equals(ascm))
            {
                Allure.addDescription("Status: PASS \n\r Type: Intra Bank Customer Registration \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " + Util.readConfigData()[2] + "\n\r To Wallet: " +toWallet+  "\n\r Name: " +name);
            }

            else
            {
                Assert.fail("Status: FAIL \n\r Type: Intra Bank Customer Registration \n\r DateTime: " +(time.toString())+ "\n\r From Wallet: " +Util.readConfigData()[2] );
            }

        }catch(Exception e)	{

                Assert.fail("Status: FAIL \n\r Type: Intra Bank Customer Registration Failed For Internal Error \n\r DateTime: " + (time.toString()));
        }

    }



}
