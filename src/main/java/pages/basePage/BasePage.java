package pages.basePage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;

}
