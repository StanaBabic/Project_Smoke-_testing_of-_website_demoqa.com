package tests.elementsPagesTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsPageTests extends ElementsPagesBaseTests {

    @Test

    public void verifyElementsPageIsOpenedIfUserClicksOnElementsCategoryCard() {

            Assert.assertEquals(getDriver().findElement(getElementsPage().getHeader()).getText(), "Elements");
            Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/elements");
    }
}