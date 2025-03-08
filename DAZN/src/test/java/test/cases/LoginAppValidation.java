package test.cases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import object.repository.ExploreTheApp;
import object.repository.LoginPage;
import object.repository.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;



public class LoginAppValidation extends Utilities {


    public static AppiumDriver<MobileElement> driver;
    static ExtentTest test;
    static ExtentReports report;
    public static String report1;
    private Dimension size;


    LoginPage RHP;
    ExploreTheApp EX;


    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
        report1 = "DAZN App Automation test report_" + fileName;
        System.out.println(report1);
        report = new ExtentReports(System.getProperty("user.dir") + "" + report1);

        report = new ExtentReports(System.getProperty("user.dir") + "/" + report1);

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "OPPO A76");
        // dc.setCapability("udid", "s4ztaa6tmbmbnbof");
        // dc.setCapability("udid", "ffd6a170");

        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "13");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.dazn");
        dc.setCapability("appActivity", "com.dazn.splash.view.SplashScreenActivity");
        //dc.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AppiumDriver<MobileElement>(url, dc);
        System.out.println("Dazn Application started");


        RHP = PageFactory.initElements(driver, LoginPage.class);
        EX = PageFactory.initElements(driver, ExploreTheApp.class);
        test = report.startTest("DAZN APP ");
		/*try {
			ScreenRecordingUtil.startRecording("testRecording.mp4");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}*/
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            captureAndEmbedScreenshot(methodName);
        }
    }

    @AfterSuite
    public void suiteTearDown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    public void captureAndEmbedScreenshot(String methodName) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.log(LogStatus.PASS, "Screenshot below: " + test.addBase64ScreenShot("data:image/png;base64," + screenshotBase64));
    }

    @Test(priority = 1)
    public void Allow() throws InterruptedException {
        Thread.sleep(5000);

        test.log(LogStatus.PASS, "Given:User Starts the Dazn App Splash Screen");
        captureAndEmbedScreenshot(" splash");

        Thread.sleep(15000);

        RHP.Allow(driver).click();
        test.log(LogStatus.PASS, "Then:User Allow the App Permissions");
        captureAndEmbedScreenshot(" Permission");


        Thread.sleep(8000);

//		RHP.signINButton(driver).click();
//		test.log(LogStatus.PASS, "Then:User Click on the signINButton");
//		captureAndEmbedScreenshot(" signINButton");
//
//
//		Thread.sleep(4000);
//
//		RHP.cancel(driver).click();

    }

    @Test(priority = 2)
    public void Explore() throws InterruptedException {
        Thread.sleep(8000);

        test = report.startTest("Explore DAZN APP ");
        TouchActions action = new TouchActions(driver);
        action.longPress(EX.exploreTheAppButtonImage(driver));
        action.release();
        action.perform();
       // EX.exploreTheAppButton(driver).click();

        test.log(LogStatus.PASS, "Then:User click on Explore ");
        captureAndEmbedScreenshot(" Explore the button");
        Thread.sleep(15000);


        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.dazn:id/tile_background\"])[2]"));
        swipeAction(firstImage, "left");
        captureAndEmbedScreenshot(" Vedio");

         driver.navigate().back();
        swipeAction(firstImage, "down");

        EX.Home(driver).click();
        captureAndEmbedScreenshot(" Home");
        test.log(LogStatus.PASS, "Then:User click on HomeMenu ");
        captureAndEmbedScreenshot(" Home");


        Thread.sleep(15000);
        EX.LandingPage(driver).click();
        test.log(LogStatus.PASS, "Then:User click on LandingPage ");

        captureAndEmbedScreenshot(" LandingPage ICON");
        Thread.sleep(8000);


    }


    @Test(priority = 2)
    public void user() throws InterruptedException {
        RHP.signINButton(driver).click();
        test.log(LogStatus.PASS, "Then:User Click on the signINButton");
        captureAndEmbedScreenshot(" signINButton");


        Thread.sleep(4000);

        RHP.cancel(driver).click();

        test = report.startTest("SIGNIN DAZN APP ");

        RHP.username(driver).sendKeys("shivakumar.mudili@dazn.com");
        test.log(LogStatus.PASS, "Then:User Enters Username");
        captureAndEmbedScreenshot(" UseName");


    }

    @Test(priority = 3)
    public void password() {
        RHP.password(driver).sendKeys("siva1996@M");
        test.log(LogStatus.PASS, "Then:User Enters Password");
        captureAndEmbedScreenshot(" Password");
    }

    @Test(priority = 4)
    public void lgnBtn() {
        RHP.lgnBtn(driver).click();
        test.log(LogStatus.PASS, "Then:User Click on StartWATCHING");
        captureAndEmbedScreenshot("lgnBtn ");
        EX.cookies(driver).click();
        test.log(LogStatus.PASS, "Then:User click on cookies ");

        captureAndEmbedScreenshot(" cookies ICON");
    }
}