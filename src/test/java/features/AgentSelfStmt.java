package features;

import browserLaunch.BasePage;
import org.openqa.selenium.By;
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


public class AgentSelfStmt extends BasePage {
    Date time = new Date(System.currentTimeMillis());

    public AgentSelfStmt() throws Exception{
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Path.xPathforAgentSelfStmt)
    public  WebElement selfStmtMenuHit;

    @FindBy(id = "selectedMonthDuration")
    public  WebElement selectedMonthDuration;

    @FindBy(id = "amount")
    public  WebElement amount;

    @FindBy(id = "viewOrgStatement")
    public  WebElement buttonClick;

    @FindBy(xpath = Path.xPathForPDF)
    public  WebElement xPathForPDF;

    @FindBy(xpath = Path.xPathForCustomerListReportDwnld)
    public  WebElement xPathForCustomerListReportDwnld;

    @FindBy(xpath = Path.xPathforAgentSelfStmt1)
    public  WebElement msg;

    @FindBy(xpath = Path.xPathforAgentSelfStmt2)
    public  WebElement noDataFound;

    @Test(priority = 1)
    public void testURL() throws InterruptedException, IOException, URISyntaxException {
        selfStmtMenuHit.click();
        Thread.sleep(2000);

    }
    @Test(priority =2 )
    public void testDuration() throws InterruptedException, IOException, URISyntaxException {
        Select dmnth = new Select(selectedMonthDuration);
        dmnth.selectByIndex(4);
        Thread.sleep(2000);

    }
    @Test(priority =3 )
    public void testConfirmButton() throws InterruptedException, IOException, URISyntaxException {
        buttonClick.click();
        Thread.sleep(2000);
        Util.attachScreenShot(driver);

    }

}