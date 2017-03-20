import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Администратор on 17.03.2017.
 */
public class OrderTab {

    private WebDriver driver;
    private static Waiters waiter;

    public OrderTab(WebDriver driver) {
        this.driver = driver;
    }

    String phone = "0001239745";
    String name = "Тестов Тест";
    String address = "Пятницкая улица, 20";
    String paymentType = "Наличные";

    By phoneFld = By.id("phone");
    By nameFld = By.id("name");
    By addressFld = By.xpath("//input[contains(@data-ng-model,'address.addressText')]");
    By paymentFld = By.id("paymentType");
    By paymentsType = By.xpath("//option[@data-ng-repeat='option in vm.orderPayMethods']");
    By firstAddress = By.xpath("//h4[@class='list-group-item-heading address-text ng-binding']");
    By cookBtn = By.xpath("//button[text()='Готовить!']");

    By filialFld = By.id("affiliate");
    By sourceFld = By.id("source");
    By dealFld = By.id("deal");
    By totalCostFld = By.xpath("//h4[@class='col-md-12 text-warning amount ng-binding ng-scope']");

    public void inputPhoneFld(){
       driver.findElement(phoneFld).sendKeys(phone);
    }

    public void inputNameFld() throws InterruptedException {
        driver.findElement(nameFld).click();
        waiter = new Waiters(driver);
        waiter.waiterLoadingPage();
        driver.findElement(nameFld).clear();
        driver.findElement(nameFld).sendKeys(name);
    }

    public void inputAddressFld(){
        driver.findElement(addressFld).sendKeys(address);
    }

    public void clickFirstAddress(){
        driver.findElement(firstAddress).click();
    }

    public void selectPaymentType(String type){
        driver.findElement(paymentFld).click();
        Select se=new Select(driver.findElement(paymentFld));
        se.selectByVisibleText(type);
        driver.findElement(paymentFld).sendKeys(Keys.ENTER);
    }

    public String getFilialFld(){
        String s =driver.findElement(filialFld).getAttribute("value");
        String value=null;
        if (s.equals("number:1")){
            value = "Новокузнецкий";
        }
        if (s.equals("number:2")){
            value = "Лихачевский";
        }
        if (s.equals("number:3")){
            value = "Калужский";
        }
        if (s.equals("number:4")){
            value = "Марьинский";
        }
        return value;
    }

    public String getSourceFld(){
        String s = driver.findElement(sourceFld).getAttribute("value");
        String value=null;
        if (s.equals("1")){
            value = "Сайт";
        }
        if (s.equals("2")){
            value = "DeliveryClub";
        }
        if (s.equals("3")){
            value = "Телефон";
        }
        if (s.equals("4")){
            value = "Obed.ru";
        }
        if (s.equals("5")){
            value = "zakazaka.ru";
        }
        if (s.equals("6")){
            value = "Маркетинг";
        }
        if (s.equals("7")){
            value = "ghpizza.ru";
        }
        if (s.equals("8")){
            value = "Вконтакте";
        }
        if (s.equals("9")){
            value = "Мобильное приложение";
        }
        if (s.equals("10")){
            value = "OneClick";
        }
        if (s.equals("11")){
            value = "Вконтакте DLVRY";
        }
        if (s.equals("99")){
            value = "Другое";
        }

        if (s.equals("100")){
            value = "Удаленный источник";
        }
        return value;
    }

    public String getDealFld(){
        return driver.findElement(dealFld).getAttribute("value");
    }

    public String getTotalCostFld(){
        return driver.findElement(totalCostFld).getText();
    }

    public void clickCook(){
        driver.findElement(cookBtn).click();
    }






}
