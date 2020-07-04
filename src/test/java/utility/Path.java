package utility;

public class Path {

    public static final String xpathForCashINURL = "//a[@href='/ChannelWeb/agentDeposit/create']";
    public static final String xPathCashIn1 = "//div[@class='alert alert-info' and @role='status']";
    public static final String xPathForStoreTxnId = ".//tr[3]/td[2]";
    public static final String xPathForStoreToWallet = ".//tr[1]/td[2]";
    public static final String xPathForStoreAmount = ".//tr[2]/td[2]";
    public static final String xpathForCashOutURL = "//a[@href='/ChannelWeb/agentWithdraw/create']";
    public static final String xPathCashOut2 = "//div[@class='alert alert-info' and @role='status']";
    public static final String xPathForDailyLimitExceedMsg = "//div[@class='alert alert-info' and @role='status']";
    public static final String xPathForPayment = "//a[@href='/ChannelWeb/agentPayment/create']";
    public static final String xPathForPayment1 = "//label[@class='control-label' and @for='toAc']";
    public static final String xPathForPayment2 = "//div[@class='alert alert-info' and @role='status']";
    public static final String xPathForIntraCusReg="//a[@href='/ChannelWeb/agentAccountReg/create']";
    public static final String xPathForIntraCusReg1="//div[contains(@class,'box-header well')]";
    public static final String xPathForIntraCusReg2="//div[@class='alert alert-info' and @role='status']";
    public static final String xPathForStoreIntraCusRegNAme=".//tr[1]/td[2]";
    public static final String xPathForStoreIntraCusRegWallet=".//tr[2]/td[2]";
    public static final String xPathforAgentSelfStmt="//a[@href='/ChannelWeb/walletStatement/obSelfStatement']";
    public static final String xPathforAgentSelfStmt1="//table[@class='table table-striped table-bordered table-condensed']";
    public static final String xPathforAgentSelfStmt2=".//div[@class='box-header well' and contains(.,'No data found')]";
    public static final String xPathForPDF="//img[@src='/ChannelWeb/plugins/jasper-1.6.1/images/icons/PDF.gif']";
    public static final String xPathForCustomerListReportDwnld=".//div[@class='box span12' and contains(.,'No data found')]";
    public static final String xPathforMerchantSelfStmtByTxnID1="//input[@class='resetBTN btn btn-primary' and contains(@onclick,'resetData();')]";


}