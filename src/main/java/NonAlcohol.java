import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Администратор on 17.03.2017.
 */
public class NonAlcohol {

    private WebDriver driver;

    public NonAlcohol(WebDriver driver) {
        this.driver = driver;
    }

    String morseBerryName = "Морс ягодный";

    By morseBerryHeader  = By.xpath(".//span[text()='Морс ягодный']");
    By morseBerryBtn = By.xpath("//*[@id='oper-top']/div[2]/div/div/div/ng-include/div[14]/div[2]/button");

    public void clickMorseBerryBtn(){
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(morseBerryHeader));
        driver.findElement(morseBerryBtn).click();
    }
}
