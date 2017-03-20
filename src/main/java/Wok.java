import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Администратор on 17.03.2017.
 */
public class Wok {
    private WebDriver driver;

    public Wok(WebDriver driver) {
        this.driver = driver;
    }

    String udonWithBeefNewpayNormalName = "Удон с говядиной Ньюпай Обычный";

    By udonWithBeefNewpayNormalHeader  = By.xpath(".//span[text()='Удон с говядиной Ньюпай']");
    By udonWithBeefNewpayNormal = By.xpath(".//*[@id='oper-top']/div[2]/div/div/div/ng-include/div[1]/div[2]/button[1]");

    public void clickUdonWithBeefNewpayNormal(){
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(udonWithBeefNewpayNormalHeader));
        driver.findElement(udonWithBeefNewpayNormal).click();
    }

}
