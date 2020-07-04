package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


public class InputConfig {

        String result = "";
        InputStream inputStream;
        String Test_case_run_by=null;
        String URL=null;
        String Login_wallet=null;
        String PIN=null;
        String CashInWallet=null;
        String amount=null;
        String CashOutWallet=null;
        String GiveBillerCode=null;
        String GiveCusMobForPayment=null;
        String GiveIntraCusForReg=null;
        String GiveIBCusForReg=null;
        String GiveNameForCusAdd=null;
        String GiveIdForCusAdd=null;
        String GiveMobileForCusAdd=null;
        String FileLocationForBulkDisburse=null;
        String GiveCustomerWalletToCollectAmount=null;
        String GiveFileLocationForBillUpload=null;
        String GiveDealerMobileForReg=null;
        String NID=null;
        String Name=null;
        String GiveWalletOfProprietor=null;
        String Address=null;
        String FileURl_PhotoUrl=null;
        String GiveDealerWalletToAdd=null;
        String GiveDealerWalletToSearch=null;
        String GiveMrMobileToRegister=null;
        String FatherName=null;
        String MotherName=null;
        String GiveMRWalletForStmt=null;
        String GiveMerchantMobileForReg=null;
        String GiveMerchantShortCodeForReg=null;
        String WalletToShowStmt=null;
        String MobileForChangeStatus=null;
        String PINForIBPush=null;
        public static final String phnNumber = Util.generateRandomMobileNumber();
        public static final String NIDNumber = Util.generateRandomNID();

        public String[] getPropValues() throws IOException {

            try {
                Properties prop = new Properties();
                String propFileName = "config.properties";

                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }

                Date time = new Date(System.currentTimeMillis());

                // get the property value and print it out
                Test_case_run_by = prop.getProperty("Automation_Script_Copyright");
                URL = prop.getProperty("URL");
                Login_wallet = prop.getProperty("Login_wallet");
                PIN = prop.getProperty("PIN");
                CashInWallet=prop.getProperty("CashInWallet");
                amount=prop.getProperty("amount");
                GiveBillerCode=prop.getProperty("GiveBillerCode");
                GiveCusMobForPayment=prop.getProperty("GiveCusMobForPayment");
                CashOutWallet=prop.getProperty("CashOutWallet");
                GiveIntraCusForReg=phnNumber;
                GiveIBCusForReg=phnNumber;
                GiveNameForCusAdd=prop.getProperty("GiveNameForCusAdd");
                GiveIdForCusAdd=prop.getProperty("GiveIdForCusAdd");
                //MobileNumberForIBReg=prop.getProperty("MobileNumberForIBReg");
                GiveMobileForCusAdd=prop.getProperty("GiveMobileForCusAdd");
                FileLocationForBulkDisburse=prop.getProperty("FileLocationForBulkDisburse");
                GiveCustomerWalletToCollectAmount=prop.getProperty("GiveCustomerWalletToCollectAmount");
                GiveFileLocationForBillUpload=prop.getProperty("GiveFileLocationForBillUpload");
                FileURl_PhotoUrl=prop.getProperty("FileURl_PhotoUrl");
                GiveDealerMobileForReg=phnNumber;
                GiveMrMobileToRegister=phnNumber;
                Address=prop.getProperty("Address");
                NID=NIDNumber;
                Name=prop.getProperty("Name");
                GiveDealerWalletToAdd=prop.getProperty("GiveDealerWalletToAdd");
                GiveDealerWalletToSearch=prop.getProperty("GiveDealerWalletToSearch");
                FatherName=prop.getProperty("FatherName");
                MotherName=prop.getProperty("MotherName");
                GiveMRWalletForStmt=prop.getProperty("GiveMRWalletForStmt");
                GiveWalletOfProprietor=prop.getProperty("GiveWalletOfProprietor");
                GiveMerchantShortCodeForReg=prop.getProperty("GiveMerchantShortCodeForReg");
                WalletToShowStmt=prop.getProperty("WalletToShowStmt");
                MobileForChangeStatus=prop.getProperty("MobileForChangeStatus");


                result = "Result = "+ Test_case_run_by + URL + ", " + Login_wallet + ", " + PIN;
                System.out.println(result + "\nProgram Ran on " + time + " by user=" + Test_case_run_by);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            return new String[]{Test_case_run_by, URL, Login_wallet, PIN, CashInWallet, amount, CashOutWallet,GiveBillerCode,GiveCusMobForPayment,GiveIntraCusForReg,NID,Name,GiveIBCusForReg };
        }

}
