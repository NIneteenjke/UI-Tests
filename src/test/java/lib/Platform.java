package lib;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Platform {

    protected RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL("http://0.0.0.0:4723");
        return new AndroidDriver(URL, getAndroidDesiredCapabilities());
    }

    private static DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and13");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.riesapp.debug");
        capabilities.setCapability("appActivity", "com.riesapp.features.root.RootActivity");
        capabilities.setCapability("app", "C:\\Users\\ninet\\Pet-proj\\UI-Test\\apks\\ries-ries-debug.apk");
        return capabilities;
    }
}
