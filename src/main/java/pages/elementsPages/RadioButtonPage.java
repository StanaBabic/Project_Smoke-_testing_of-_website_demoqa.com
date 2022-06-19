package pages.elementsPages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

@Getter
@Setter
public class RadioButtonPage extends BasePage {
    private By radioButtons=By.id("item-2");
    private By yesRadioBtn= By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressiveRadioBtn=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By noRadioButton=By.xpath("//input[@id='noRadio']");
    private By header=By.className("main-header");
    private By message=By.className("mt-3");

    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void clickOnRadioButtons(){
        getDriver().findElement(radioButtons).click();
    }
    public void clickOnYesRadioButton(){getDriver().findElement(this.yesRadioBtn).click();}
    public void clickOnImpressiveRadioButton(){
        getDriver().findElement(impressiveRadioBtn).click();
    }

}
