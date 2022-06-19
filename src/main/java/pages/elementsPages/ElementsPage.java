package pages.elementsPages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

@Getter
@Setter
public class ElementsPage extends BasePage {

    private By textBox=By.id("item-0");
    private By checkBox=By.id("item-1");
    private By radioButton=By.id("item-2");
    private By webTables=By.id("item-3");
    private By buttons=By.id("item-4");
    private By links=By.id("item-5");
    private By brokenLinksImages=By.id("item-6");
    private By uploadAndDownload=By.id("item-7");
    private By dynamicProperties=By.id("item-8");
    private By header=By.className("main-header");

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

}
