package helpers;

import helpers.HelperBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    @Step("Перейти назад")
    public void back() {
        driver.navigate().back();
    }

    @Step("Перейти в Товары для животных > Товары для кошек > Лакомства")
    public void goToCategory(String category, int bloc, String link) {
        click(By.className("n-w-tab__control-hamburger"));
        moveTo(By.linkText(category));
        click(By.xpath("//*[@class='n-w-navigation-menu__nodes']/div[" + bloc + "]/a[text()='" + link + "']"));
    }

    @Step("Перейти в Сравнение")
    public void goToCompareProducts() {
        click(By.xpath("//span[text() = 'Сравнение']"));
    }
}