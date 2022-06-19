package pages.elementsPages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

import java.util.List;

@Getter
@Setter
public class WebTablesPage extends BasePage {
    private By webTablesBtn=By.id("item-3");
    private By addBtn=By.id("addNewRecordButton");
    private By searchField=By.id("searchBox");
    private By searchBtn=By.id("basic-addon2");
    private By firstName=By.id("firstName");
    private By lastName=By.id("lastName");
    private By eEmail=By.id("userEmail");
    private By age=By.id("age");
    private By salary=By.id("salary");
    private By department=By.id("department");
    private By submitBtn=By.id("submit");
    private By lastNameOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]");
    private By firstNameOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]");
    private By firstNameSearchOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]");
    private By eMailOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]");
    private By ageOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]");
    private By salaryOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]");
    private By salaryEditOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[5]");
    private By departmentOutput=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]");
    private By header=By.className("main-header");
    private By editBtn=By.id("edit-record-1");
    private By deleteBtn=By.id("delete-record-1");
    private By tableRow=By.className("rt-tr-group");
    private By tableSize=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select");

    public WebTablesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnWebTablesBtn(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy (0,500)");
        getDriver().findElement(webTablesBtn).click();
    }

    public void submitConfirmationForm(String firstName, String lastName, String eMail, String age, String salary, String department){
        getDriver().findElement(this.firstName).sendKeys(firstName);
        getDriver().findElement(this.lastName).sendKeys(lastName);
        getDriver().findElement(this.eEmail).sendKeys(eMail);
        getDriver().findElement(this.age).sendKeys(age);
        getDriver().findElement(this.salary).sendKeys(salary);
        getDriver().findElement(this.department).sendKeys(department);
        getDriver().findElement(this.submitBtn).submit();
    }


    public void enterSearchingData(String searchingData){
        getDriver().findElement(this.searchField).sendKeys(searchingData);
        getDriver().findElement(searchBtn).click();
    }

    public void editConfirmationFormInput(String salary){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(getEditBtn()));
        actions.perform();
        getDriver().findElement(getEditBtn()).click();
        getDriver().findElement(this.salary).clear();
        getDriver().findElement(this.salary).sendKeys(salary);
        getDriver().findElement(this.submitBtn).click();

    }

    public void deleteDataFromWebTable(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(getDeleteBtn()));
        actions.perform();
        getDriver().findElement(getDeleteBtn()).click();
    }


    public void clickOnSelectTableSize(){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy (0,500)");
        getDriver().findElement(getTableSize()).click();
    }

    public void selectTableSize(String rowsPerPage){
        Select drpTableSize=new Select(getDriver().findElement(getTableSize()));
        drpTableSize.selectByVisibleText(rowsPerPage);
    }

    public int getNumbersOfRowsPerPage(){
        List<WebElement> table=getDriver().findElements(getTableRow());
        return table.size();
    }
}
