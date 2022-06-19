package tests.elementsPagesTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxPageTests extends ElementsPagesBaseTests{

    @BeforeMethod
    public void clickOnCheckBox(){
        getCheckBoxPage().clickOnCheckBox();
        getCheckBoxPage().clickOnExpandAllBtn();
    }
    @Test(priority = 1)
    public void verifyCheckBoxPageIsOpenedIfUserClicksOnCheckBox(){

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/checkbox");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getHeader()).getText(), "Check Box");
    }

    @Test (priority = 2)
    public void verifyCheckBoxWithAllFoldersAndFilesIsDisplayedIfUserClicksOnExpandAllBtn (){

        Assert.assertTrue(getDriver().findElement(getCheckBoxPage().getOrderedList()).isDisplayed());
    }

    @Test (priority = 3)
    public void verifyOnlyHomeFolderIsDisplayedIfUserClicksOnCollapseAllBtn (){

        getCheckBoxPage().clickOnCollapseAllBtn();
        Assert.assertTrue(getDriver().findElement(getCheckBoxPage().getHomeFolder()).isDisplayed());
    }

    @Test (priority = 4)
    public void verifyAllFolderAndFilesAreSelectedIfUserClicksOnHomeCheckBoxBtn (){

        getCheckBoxPage().clickOnHomeCheckBoxBtn();
        Assert.assertEquals(getDriver().findElement(getCheckBoxPage().getMessage()).getText(),"You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
}
    @Test (priority = 5)
    public void verifyAllFoldersAndFilesAreDeselectedIfUserClicksTwiceOnHomeCheckBoxBtn(){

        getCheckBoxPage().clickOnHomeCheckBoxBtn();
        getCheckBoxPage().clickOnHomeCheckBoxBtn();
        Assert.assertFalse(getDriver().findElement(getCheckBoxPage().getOrderedList()).isSelected());
    }
 }