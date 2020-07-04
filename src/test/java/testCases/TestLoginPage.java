package testCases;

import features.LogIn;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

public class TestLoginPage {
    LogIn logIn;
    Date time = new Date(System.currentTimeMillis());
    @BeforeTest
    public void init() throws Exception {
        logIn = new LogIn();
    }
    @Test(priority = 0,alwaysRun = true, groups = "TestLoginPage")
    public void testLauchBrowser() throws IOException, InterruptedException, URISyntaxException {
        logIn.testLaunchBrowser();
    }
    @Test(priority = 1,alwaysRun = true, groups = "TestLoginPage")
    public void testUserName() throws IOException, InterruptedException, URISyntaxException {
        logIn.testUserName();
    }
    @Test(priority = 2,alwaysRun = true, groups = "TestLoginPage")
    public void testUserPIN() throws IOException, InterruptedException, URISyntaxException {
        logIn.testPIN();
    }
    @Test(priority = 3,alwaysRun = true, groups = "TestLoginPage")
    public void testRememberChkBox() throws IOException, InterruptedException, URISyntaxException {
        logIn.testRememberChkBox();
    }
    @Test(priority = 4,alwaysRun = true, groups = "TestLoginPage")
    public void testConfirmButton() throws IOException, InterruptedException, URISyntaxException {
        logIn.testConfirmButton();
    }

}
