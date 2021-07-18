import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonPatern {
    KeyString keyString = new KeyString();
    WebDriver webDriver;

    private static SingletonPatern obj = new SingletonPatern();

    //We Make Constructor as Private so other class will not create object
    private SingletonPatern() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty(keyString.KEY_CHROME_DRIVER, keyString.KEY_PATH_INSTALL_CHROME);
        webDriver = new ChromeDriver(options);
        webDriver.get(keyString.KEY_LINK_WEB);
        webDriver.manage().window().maximize();
        webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_STATUS_NOT_LOGIN_YET)).click();

    }

    public static SingletonPatern getObject() {
        return obj;
    }

    //Other Method protected by Singleton-ness
    public static void demomethod() {
        System.out.println("Singleton Design Pattern Method 1");
    }
}
