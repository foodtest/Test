import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Администратор on 17.03.2017.
 */
public class NewOrder {
    private WebDriver driver;

    public NewOrder(WebDriver driver) {
        this.driver = driver;
    }

    private String url = "/operator/new/products";
    String wok = "WOK";
    String nonalc = "Безалкогольные";


    By products = By.xpath("//a[@class='item-header ng-binding']");
    By addedProducts = By.xpath("//div[@class='tr row']");
    By numberProduct = By.xpath("//span[@class='ng-binding ng-scope']");
    By nameProduct = By.xpath("//div[@class='td col-3']/strong[@class='ng-binding']");
    By plusIconFirst = By.xpath("//div[@class='tbody']/div[1]/div/div[2]/button");
    By plusIconSecond = By.xpath("//div[@class='tbody']/div[2]/div/div[2]/button");
    By countDish = By.xpath("//div[@class='tr row']/div[3]/span");
    By addCommentFirst = By.id("dish-comment-text-0");
    By addCommentSecond = By.id("dish-comment-text-1");
    By price = By.xpath("//div[@class='tr row']/div[4]");
    By cost = By.xpath("//div[@class='tr row']/div[6]/strong");
    By discount = By.xpath("//form[contains(@class,'max')]");
    By addIcon = By.xpath("//button[@data-ng-click='vm.plusDish(item)']/i");
    By totalCost = By.xpath("//div[@class='td col-md-3']/strong[2]");

    By orderBtn = By.xpath("//a[@data-ui-sref='.order']");




    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getUrl(){
        return url;
    }

    public void clickProduct(String product){
        List<WebElement> list = driver.findElements(products);
        for (WebElement x : list){
            if (x.getText().equals(product)){
                x.click();
                return;
            }
        }
    }

    public int countAddedProducts(){
        List<WebElement> list = driver.findElements(addedProducts);
        return list.size();
    }

    public String getNumberProduct(int row){
        List<WebElement> list = driver.findElements(numberProduct);
        return list.get(row-1).getText();
    }

    public String getNameProduct(int row){
        List<WebElement> list = driver.findElements(nameProduct);
        return list.get(row-1).getText();
    }

    public String getCountDish(int row){
        List<WebElement> list = driver.findElements(countDish);
        return list.get(row-1).getText();
    }

    public String getPrice(int row){
        List<WebElement> list = driver.findElements(price);
        return list.get(row-1).getText();
    }

    public String getCost(int row){
        List<WebElement> list = driver.findElements(cost);
        return list.get(row-1).getText();
    }

    public String getDiscount(int row){
        List<WebElement> list = driver.findElements(discount);
        return list.get(row-1).getText().substring(2);
    }

    public String getTotalCost(){
        return driver.findElement(totalCost).getText();
    }

    public void clickAddIcon(int row){
        List<WebElement> list = driver.findElements(addIcon);
        list.get(row-1).click();
    }

    public void clickOrder(){
        driver.findElement(orderBtn).click();
    }










}
