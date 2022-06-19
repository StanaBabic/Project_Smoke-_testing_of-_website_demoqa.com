package pages.elementsPages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

@Getter
@Setter
public class TextBoxPage extends BasePage {

    private By header=By.className("main-header");
    private By textBox = By.className("text");
    private By fullName = By.id("userName");
    private By eMail = By.id("userEmail");
    private By currentAddress =By.id("currentAddress");
    private By permanentAddress =By.id("permanentAddress");
    private By submitBtn = By.id("submit");
    private By nameInTextBox =By.id("name");
    private By emailInTextBox = By.id("email");
    private By currentAddressInTextBox =By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]");
    private By permanentAddressInTextBox =By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]");

    public TextBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public void clickOnTextBox(){
        getDriver().findElement(textBox).click();
    }

    public void enterInputDataIntoTextBox(String fullName, String eMail, String currentAddress, String permanentAddress ){
        getDriver().findElement(this.fullName).sendKeys(fullName);
        getDriver().findElement(this.eMail).sendKeys(eMail);
        getDriver().findElement(this.currentAddress).sendKeys(currentAddress);
        getDriver().findElement(this.permanentAddress).sendKeys(permanentAddress);
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy (0,500)");
        getDriver().findElement(this.submitBtn).click();
    }
}
