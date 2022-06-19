package tests.elementsPagesTests;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.elementsPages.*;
import pages.homePage.HomePage;


import java.time.Duration;

@Getter
public abstract class ElementsPagesBaseTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;
    private CheckBoxPage checkBoxPage;
    private RadioButtonPage radioButtonPage;
    private WebTablesPage webTablesPage;

    @BeforeClass

    public void setup(){

            System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
            driver=new ChromeDriver();
            driverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            homePage=new HomePage(driver,driverWait);
            elementsPage=new ElementsPage(driver,driverWait);
            textBoxPage=new TextBoxPage(driver, driverWait);
            checkBoxPage=new CheckBoxPage(driver,driverWait);
            radioButtonPage=new RadioButtonPage(driver,driverWait);
            webTablesPage=new WebTablesPage(driver,driverWait);

        }

     @BeforeMethod

     public void beforeMethod(){
         driver.navigate().to("https://demoqa.com/");
         driver.manage().window().maximize();
         JavascriptExecutor js=(JavascriptExecutor) getDriver();
         js.executeScript("window.scrollBy (0,500)");
         driverWait.until(ExpectedConditions.elementToBeClickable(getHomePage().getElementsCategoryCard()));
         getHomePage().clickOnElementsCategoryCard();
     }

       @AfterClass

        public void afterClass(){
            driver.close();
        }


}
