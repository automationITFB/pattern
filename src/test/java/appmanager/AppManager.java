package appmanager;

import helpers.MarketHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    WebDriver driver;
    private MarketHelper market;
    private NavigationHelper navigate;

    public void init() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        market = new MarketHelper(driver);
        navigate = new NavigationHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public MarketHelper market() {
        return market;
    }

    public NavigationHelper navigate() {
        return navigate;
    }
}
