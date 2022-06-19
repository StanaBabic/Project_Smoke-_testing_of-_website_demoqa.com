package pages.homePage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

@Getter

public class HomePage extends BasePage {


    private final By elementsCategoryCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public void clickOnElementsCategoryCard() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(elementsCategoryCard));
        getDriver().findElement(elementsCategoryCard).click();

    }

}