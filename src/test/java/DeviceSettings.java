import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceSettings {
    private static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> getAndroidDriver() {
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<AndroidElement>(url, DeviceCapabilities.getAndroidCapabilities());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }
}