package utility;

import browserLaunch.BrowserOpening;
import org.openqa.selenium.Alert;
import push.*;
import io.qameta.allure.Attachment;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

public class Util {

    @Attachment(value = "ScreenShot", type = "image/png")
    public static byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    public static String[] readConfigData() throws IOException {
        InputConfig ip=new InputConfig();
        String result[] = ip.getPropValues();
        return result;
    }
    public static int PushForLogin() throws InterruptedException, IOException, URISyntaxException {
        PushForLogin pushForLogin = new PushForLogin();
        int push = pushForLogin.PushApi();
        System.out.printf("Push value is " + push);
        return push;
    }
    public static void alertMessageHandle() throws Exception{
        Alert alert3 = BrowserOpening.driver.switchTo().alert();
        Thread.sleep(3000);
        String alertMessage3= BrowserOpening.driver.switchTo().alert().getText();
        System.out.println(alertMessage3);
        Thread.sleep(2000);
        alert3.accept();
        Thread.sleep(2000);

    }

    public static String generateRandomMobileNumber(){
        String operatorCode = "015";
        String phoneNumber = operatorCode + RandomStringUtils.randomNumeric(8);
        return phoneNumber;
    }

    public static String generateRandomPUSH(){
        String push = RandomStringUtils.randomNumeric(4);
        return push;
    }
    public static int PushForIntraCusReg() throws InterruptedException, IOException, URISyntaxException {
        PushForIntraReg pushForIntraReg = new PushForIntraReg();
        int push = pushForIntraReg.PushApi();
        System.out.printf("Push value is " + push);
        return push;
    }

    public static String generateRandomNID(){
        String FirstThrreeDigit="114";
        String NIDNumber =FirstThrreeDigit+RandomStringUtils.randomNumeric(10);
        return NIDNumber;
    }
    public static int PushForCashOut() throws InterruptedException, IOException, URISyntaxException {
        PushForCashOut pushForCashOut = new PushForCashOut();
        int push = pushForCashOut.PushApiForCashOut();
        System.out.printf("Push value is " + push);
        return push;
    }
}

