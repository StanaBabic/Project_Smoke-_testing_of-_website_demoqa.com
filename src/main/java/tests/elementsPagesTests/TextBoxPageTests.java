package tests.elementsPagesTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxPageTests extends ElementsPagesBaseTests{
    @BeforeMethod
    public void clickOnTextBox(){
        getTextBoxPage().clickOnTextBox();
    }
    @Test(priority=1)
    public  void verifyTextBoxPageIsOpenedIfUserClicksOnTextBox(){

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/text-box");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getHeader()).getText(), "Text Box");}

    @Test (priority = 2)
    public void verifyTextBoxIsDisplayed(){

        getTextBoxPage().enterInputDataIntoTextBox("Stana Babic", "stanababic@example.com", "stanaadzic@gmail.com", "stanababic@example.com");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getNameInTextBox()).getText(), "Name:Stana Babic");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getEmailInTextBox()).getText(), "Email:stanababic@example.com");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getCurrentAddressInTextBox()).getText(), "Current Address :stanaadzic@gmail.com");
        Assert.assertEquals(getDriver().findElement(getTextBoxPage().getPermanentAddressInTextBox()).getText(), "Permananet Address :stanababic@example.com");
    }
}
