
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileTest {

    public static void main(String args[]) throws MalformedURLException, InterruptedException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        //cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\dssri\\Desktop\\apkfile\\indiamart.apk");
        cap.setCapability("appPackage", "com.google.android.youtube");
        cap.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cap);
        System.out.println(driver.isAppInstalled("com.google.android.youtube"));
        String session = driver.getSessionId().toString();
        System.out.println("Session" + session);
        Map<String, Object> caps = driver.getSessionDetails();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ScreenOrientation orientation = driver.getOrientation();
        driver.rotate(ScreenOrientation.LANDSCAPE);
        System.out.println(orientation.toString());
        Location location = driver.location();
        System.out.println(location.getAltitude());
        System.out.println(driver.getEvents());
        Map<String, Object> settings = driver.getSettings();
        System.out.println(settings);
        driver.runAppInBackground(Duration.ofSeconds(10));
       driver.closeApp();
       driver.installApp("C:\\Users\\dssri\\Downloads\\com.flipkart.android.1320000.apk");

        driver.hideKeyboard();








        System.out.println(caps);


    }
}