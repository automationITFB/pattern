package helpers;

import helpers.HelperBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MarketHelper extends HelperBase {
    public MarketHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Установить фильтр по доставке")
    public void chooseDeliveryOn() {
        click(By.xpath("//*[text()='Цена с учётом доставки']"));
    }

    @Step("Установить Фильтр по цене")
    public void priceFilter(String priceFrom, String priceTo) {
        driver.findElement(By.name("Цена от")).sendKeys(priceFrom);
        driver.findElement(By.name("Цена до")).sendKeys(priceTo);
    }

    @Step("Выбрать производителя")
    public void chooseMaker(String maker) {
        WebElement element = driver.findElement(By.xpath("//input[@name='Производитель " + maker + "']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    @Step("Убрать производителя")
    public void deleteMaker(String maker) {
        WebElement element = driver.findElement(By.xpath("//input[@name='Производитель " + maker + "']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    @Step("Выбрать товар из списка добавить в сравнение")
    public void getProduct(int number) {
        driver.findElements(By.xpath("//*[@class='n-snippet-card2__part n-snippet-card2__part_type_left']/a")).get(number).click();
        click(By.xpath("//*[text()='Сравнить']"));
    }

    public int price(int number) {
        String elementText = driver.findElements(By.className("price")).get(number).getText().replaceAll("\\D+", "");
        int price = Integer.parseInt(elementText);
        return price;
    }

    @Step("Проверка суммы стоимостей товаров")
    public void checkPriceSumm() {
        assertTrue((price(0) + price(1)) < 300);
    }

    @Step("Проверить, что товар производителя Dreamies отображается")
    public void checkElementDisplayedTrue(String maker) {
        assertTrue(isElementPresent(maker));
    }

    @Step("Проверить, что товар производителя Dreamies не отображается")
    public void checkElementDisplayedFalse(String maker) {
        assertFalse(isElementPresent(maker));
    }

    public boolean isElementPresent(String maker) {
        try {
            driver.findElement(By.partialLinkText(maker));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Step("Удалить товар из сравнения")
    public void delete(int number) {
        WebElement element = driver.findElements(By.xpath("//*[@class='n-compare-head__toolbar']/span")).get(number);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    @Step("Удалить все товары из сравнения")
    public void deleteAll() {
        click(By.xpath("//*[text()='Удалить список']"));
    }

    public void waiting() throws InterruptedException {
        Thread.sleep(3000);
    }

}
