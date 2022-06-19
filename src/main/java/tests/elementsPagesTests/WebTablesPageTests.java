package tests.elementsPagesTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebTablesPageTests extends ElementsPagesBaseTests{
    @BeforeMethod
    public void clickOnWebTablesBtn(){
        getWebTablesPage().clickOnWebTablesBtn();
    }
    @Test (priority = 1)
    public void verifyWebTablesPageIsOpenedIfUserClicksOnWebTables(){

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/webtables");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getHeader()).getText(), "Web Tables");}

    @Test (priority = 2)
    public void verifyNewPersonalDataIsAddedToWebTableIfUserEntersInputData(){

        getDriver().findElement(getWebTablesPage().getAddBtn()).click();
        getWebTablesPage().submitConfirmationForm("Stana", "Babic","stanababic@example.com", "38", "100000", "QA");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getFirstNameOutput()).getText(),"Stana");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getLastNameOutput()).getText(), "Babic");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getAgeOutput()).getText(),"38");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getEMailOutput()).getText(), "stanababic@example.com");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getSalaryOutput()).getText(), "100000");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getDepartmentOutput()).getText(), "QA");
    }
    @Test (priority =3)
    public void verifyOutputInWebTableMatchesDataUserIsSearchingFor(){

        getWebTablesPage().enterSearchingData("Cierra");
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getWebTablesPage().getFirstNameSearchOutput()));
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getFirstNameSearchOutput()).getText(), "Cierra");
    }
    @Test  (priority =4)
    public void verifyOutputInWebTableMatchesDataUserHasChangedByEditingConfirmationFormInput(){

        getWebTablesPage().editConfirmationFormInput("120000");
        Assert.assertEquals(getDriver().findElement(getWebTablesPage().getSalaryEditOutput()).getText(), "120000");
    }

    @Test (priority =5)
    public void verifyChosenDataAreDeletedFromWebTableIfUserClicksOnDeleteBtn(){

        getWebTablesPage().deleteDataFromWebTable();
        getWebTablesPage().enterSearchingData("Cierra");
        Assert.assertFalse(getDriver().findElement(getWebTablesPage().getFirstNameSearchOutput()).getText().contains("Cierra"));
    }

    @Test (priority = 6)
    public void verifyRowsPerPageIsAsUserHasSelected(){
        getWebTablesPage().clickOnSelectTableSize();
        getWebTablesPage().selectTableSize("20 rows");
        Assert.assertEquals(getWebTablesPage().getNumbersOfRowsPerPage(), 20);
    }
}
