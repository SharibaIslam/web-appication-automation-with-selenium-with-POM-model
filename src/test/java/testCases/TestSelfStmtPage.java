package testCases;

import features.AgentSelfStmt;
import features.CashIn;
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

public class TestSelfStmtPage {
    AgentSelfStmt agentSelfStmt;
    Date time = new Date(System.currentTimeMillis());
    WebElement ee1,ee2,ee3;
    String txnId,toWallet,amount,ascm2;
    @BeforeTest
    public void init() throws Exception {
        agentSelfStmt = new AgentSelfStmt();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testMenuURL() throws IOException, InterruptedException, URISyntaxException {
        agentSelfStmt.testURL();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testDuration() throws IOException, InterruptedException, URISyntaxException {
        Assert.assertTrue(agentSelfStmt.selectedMonthDuration.isDisplayed(), "Login test PASS");
        agentSelfStmt.testDuration();
    }

    @Test(priority = 3,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        agentSelfStmt.testConfirmButton();
    }
  @Test(priority = 4,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testReportDownload() throws IOException, InterruptedException, URISyntaxException {
      try {
          WebElement mself =agentSelfStmt.xPathForPDF;
          mself.click();
          Allure.addDescription("Status: PASS \n\r Type: Wallet statement Report download \n\r DateTime: " +(time.toString())+ "\n\r Input Wallet For Search: " + Util.readConfigData()[2]);
      } catch (Exception e) {
          try {
              WebElement asuc1 =agentSelfStmt.xPathForCustomerListReportDwnld;
              String asc2 = asuc1.getText();
              String ascm3 = "No data found";
              System.out.println(asc2);
              if (asc2.equals(ascm3)) {
                  Allure.addDescription("Status: PASS \n\r Type: Report export \n\r DateTime: " + (time.toString()) + "\n\r Input Wallet For Search: " + Util.readConfigData()[2]);
              }
          } catch (Exception f) {
              Assert.fail("Status: FAIL \n\r Type: Report export \n\r DateTime: " + (time.toString()) + "\n\r Input Wallet For Search: " + Util.readConfigData()[2]);
          }
      }
    }

    @Test(priority = 5,alwaysRun = true, groups = "TestCashInPage",dependsOnGroups = "TestLoginPage")
    public void testCaseForStmtDownload() throws IOException, InterruptedException, URISyntaxException {
        try {

            if((agentSelfStmt.msg).isDisplayed())
            {
                Allure.addDescription("Status: PASS \n\r Type: Self statement search by date \n\r DateTime: " +(time.toString())+ "\n\r Input Wallet For Search: " +Util.readConfigData()[2]);
            }
        }

        catch(Exception e) {

            try{
                WebElement asuc1 = agentSelfStmt.noDataFound;
                //WebElement asuc1 = driver.findElement(By.xpath("//h2[text()='No data found']"));
                String asc2=asuc1.getText();
                String ascm3="No data found";
                System.out.println(asc2);
                if(asc2.equals(ascm3)) {
                    Allure.addDescription("Status: PASS \n\r Type: Have No Data \n\r DateTime: " +(time.toString())+ "\n\r Input Wallet For Search: " +Util.readConfigData()[2]);
                }
            }catch(Exception f) {
                Assert.fail("Status: FAIL \n\r Type: Self statement search by date failed for Internal Error \n\r DateTime: " +(time.toString())+ "\n\r Input Wallet For Search: " +Util.readConfigData()[2]);
            }
        }

    }


}
