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


public class AgentSelfStmtByTxnID extends BasePage {
    Date time = new Date(System.currentTimeMillis());
    String gaw123;
    public AgentSelfStmtByTxnID() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xPathforAgentSelfStmt)
    public  WebElement selfStmtMenuHit;

    @FindBy(id = "selectedMonthDuration")
    public  WebElement selectedMonthDuration;

    @FindBy(id = "amount")
    public  WebElement amount;

    @FindBy(name = "viewOrgStatement")
    public  WebElement buttonClick;

    @FindBy(xpath = Path.xPathForPDF)
    public  WebElement xPathForPDF;

    @FindBy(xpath = Path.xPathForCustomerListReportDwnld)
    public  WebElement xPathForCustomerListReportDwnld;

    @FindBy(xpath = Path.xPathforAgentSelfStmt1)
    public  WebElement msg;

    @FindBy(xpath = Path.xPathforAgentSelfStmt2)
    public  WebElement noDataFound;

    @FindBy(xpath = ".//td[4]")
    public  WebElement txnIDStore;

    @FindBy(xpath = Path.xPathforMerchantSelfStmtByTxnID1)
    public  WebElement txnID1;

    @FindBy(id = "transactionId")
    public  WebElement txnID2;

    @Test(priority = 1)
    public void testURL() throws InterruptedException, IOException, URISyntaxException {
        selfStmtMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testDuration() throws InterruptedException, IOException, URISyntaxException {
        Select dmnth = new Select(selectedMonthDuration);
        dmnth.selectByIndex(1);
        Thread.sleep(2000);

    }
    @Test(priority =3 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        buttonClick.click();
        Thread.sleep(3000);
        Util.attachScreenShot(driver);

    }
    @Test(priority =4 )
    public void testCustomerWalletStmtByTxnIdConfirm() throws InterruptedException, IOException, URISyntaxException {
        try {
            if (txnID1.isDisplayed()) {
                txnID1.click();
                Thread.sleep(2000);
                gaw123 = txnIDStore.getText();
                txnID2.sendKeys(gaw123);
                Thread.sleep(3000);
                WebElement ag2 = buttonClick;
                ag2.click();
                Thread.sleep(2000);
                Util.attachScreenShot(driver);
            }

        } catch (Exception e) {
            System.out.println("No Txn ID is found to search");
        }

    }

}