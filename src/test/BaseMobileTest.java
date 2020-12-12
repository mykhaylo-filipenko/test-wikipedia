package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseMobileTest {

    private static String LOCAL_URL = "http://localhost:4723/wd/hub";

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "org.wikipedia");
        dc.setCapability("appActivity", ".main.MainActivity");
        return dc;
    }

    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = getDesiredCapabilities();
        return new AndroidDriver<>(new URL(LOCAL_URL), capabilities);
    }
}
