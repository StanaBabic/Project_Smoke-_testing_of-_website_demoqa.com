package tests.elementsPagesTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends ElementsPagesBaseTests{
    @BeforeMethod
    public void clickOnRadioButtons(){
        getRadioButtonPage().clickOnRadioButtons();
    }

    @Test (priority = 1)
    public void verifyRadioButtonPageIsOpenedIfUserClicksOnRadioButton(){

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/radio-button");
        Assert.assertEquals(getDriver().findElement(getRadioButtonPage().getHeader()).getText(), "Radio Button");
    }

    @Test (priority = 2)
    public void verifyMatchingMessageIsDisplayedIfUserClicksOnYesRadioBtn(){
        getRadioButtonPage().clickOnYesRadioButton();
        Assert.assertTrue(getDriver().findElement(getRadioButtonPage().getYesRadioBtn()).isEnabled());
        Assert.assertFalse(getDriver().findElement(getRadioButtonPage().getImpressiveRadioBtn()).isSelected());
        Assert.assertEquals(getDriver().findElement(getRadioButtonPage().getMessage()).getText(), "You have selected Yes");
    }

    @Test (priority = 3)
    public void verifyMatchingMessageIsDisplayedIfUserClicksOnImpressiveRadioBtn(){

        getRadioButtonPage().clickOnImpressiveRadioButton();
        Assert.assertTrue(getDriver().findElement(getRadioButtonPage().getImpressiveRadioBtn()).isEnabled());
        Assert.assertFalse(getDriver().findElement(getRadioButtonPage().getYesRadioBtn()).isSelected());
        Assert.assertEquals(getDriver().findElement(getRadioButtonPage().getMessage()).getText(), "You have selected Impressive");
    }

    @Test (priority = 4)
    public void verifyNoRadioBtnIsDisabled(){

        Assert.assertFalse(getDriver().findElement(getRadioButtonPage().getNoRadioButton()).isEnabled());
    }
}
