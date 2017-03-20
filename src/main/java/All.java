import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Администратор on 17.03.2017.
 */
public class All {
    private WebDriver driver;
    private String url = "/operator/all";

    public All(WebDriver driver) {
        this.driver = driver;
    }
    String status = "на кухне";
    String filial = "Новокузнецкий";
    String address = "Россия, Москва, Пятницкая улица, 20";
    String client = "Клиент: Тестов Тест +7 (000) 1239745";
    String cost = "Сумма: 825 р.";

    private By newOrderBtn = By.xpath("//a[@href='/operator/new/products']");
    By searchFld = By.xpath("//input[@data-ng-model='vm.searchText']");
    private By searchBtn = By.id("go");
    private By statusFlds = By.xpath("//h3[@class='ng-binding']");
    private By filialFlds = By.xpath("//h4[@class='ng-binding']");
    private By addressFlds = By.xpath("//p/strong[@class='ng-binding']");
    private By clientFlds = By.xpath("//div[@class='col-md-5 order-list-head ng-scope']/p[2]");
    private By costFlds = By.xpath("//p[@class='total-amount ng-binding']");

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getUrl(){
        return url;
    }

    public void clickNewOrderBtn(){
        driver.findElement(newOrderBtn).click();
    }

    public void inputSearchFld(){
        driver.findElement(searchFld).sendKeys("0001239745");
    }

    public void clickSearchBtn(){
        driver.findElement(searchBtn).click();
    }

    public String getLastStatus(){
        List<WebElement> list = driver.findElements(statusFlds);
        return list.get(list.size()-1).getText();
    }

    public String getLastFilial(){
        List<WebElement> list = driver.findElements(filialFlds);
        return list.get(list.size()-1).getText();
    }

    public String getLastAddress(){
        List<WebElement> list = driver.findElements(addressFlds);
        return list.get(list.size()-1).getText();
    }

    public String getLastClient(){
        List<WebElement> list = driver.findElements(clientFlds);
        return list.get(list.size()-1).getText();
    }

    public String getLastCost(){
        List<WebElement> list = driver.findElements(costFlds);
        return list.get(list.size()-1).getText();
    }




}
