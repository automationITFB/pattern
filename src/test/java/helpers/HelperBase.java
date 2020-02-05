package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void moveTo(By locator) {
        WebElement element = driver.findElement(locator);
        Actions build = new Actions(driver);
        build.moveToElement(element).build().perform();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
