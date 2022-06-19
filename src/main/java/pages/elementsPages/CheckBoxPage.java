package pages.elementsPages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

@Getter
@Setter
public class CheckBoxPage extends BasePage{

    private By checkBox= By.id("item-1");
    private By expandAllBtn=By.xpath("//*[@id=\"tree-node\"]/div/button[1]");
    private By collapseAllBtn=By.xpath("//*[@id=\"tree-node\"]/div/button[2]");
    private By homeCheckBoxBtn=By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    private By desktopCheckBoxBtn=By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg > path");
    private By notesCheckBoxBtn=By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label");
    private By commandsCheckBoxBtn=By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label");
    private By orderedList=By.xpath("//*[@id=\"tree-node\"]/ol");
    private By homeFolder=By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    private By message=By.id("result");

    public CheckBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void clickOnCheckBox(){

            getDriver().findElement(getCheckBox()).click();
    }
     public void clickOnExpandAllBtn(){
            getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getExpandAllBtn()));
            getDriver().findElement(getExpandAllBtn()).click();
     }

     public void clickOnCollapseAllBtn(){
            getDriver().findElement(getCollapseAllBtn()).click();
     }

     public void clickOnHomeCheckBoxBtn(){
            getDriverWait().until(ExpectedConditions.elementToBeClickable(getHomeCheckBoxBtn()));
            getDriver().findElement(getHomeCheckBoxBtn()).click();
    }

     public void clickOnNotesCheckBoxBtn(){
         getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getNotesCheckBoxBtn()));
         getDriver().findElement(getHomeCheckBoxBtn()).click();
     }
}
