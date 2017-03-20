import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 17.03.2017.
 */
public class MyTest {
    private static WebDriver driver;
    private static Login loginPage;
    private static All allPage;
    private static NewOrder newOrderPage;
    private static Wok wokPage;
    private static Waiters waiter;
    private static NonAlcohol nonAlcoholPage;
    private static OrderTab orderTabPage;

    @BeforeSuite
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://88.99.27.54:6016/");
        driver.manage().window().maximize();
        loginPage = new Login(driver);
        allPage = new All(driver);
        newOrderPage = new NewOrder(driver);
        wokPage = new Wok(driver);
        waiter = new Waiters(driver);
        nonAlcoholPage = new NonAlcohol(driver);
        orderTabPage = new OrderTab(driver);
    }

    @Test(description = "Добавление блюд в заказ")
    public void TC1(){

        loginPage.loginComplete();
        allPage.clickNewOrderBtn();
        Assert.assertTrue(newOrderPage.getCurrentUrl().contains(newOrderPage.getUrl()));
        newOrderPage.clickProduct(newOrderPage.wok);
        wokPage.clickUdonWithBeefNewpayNormal();
        Assert.assertTrue(newOrderPage.countAddedProducts()>0);
        Assert.assertEquals(newOrderPage.getNumberProduct(1),"1");
        Assert.assertEquals(newOrderPage.getNameProduct(1),wokPage.udonWithBeefNewpayNormalName);
        Assert.assertTrue(waiter.isElementPresent(newOrderPage.plusIconFirst));
        Assert.assertEquals(newOrderPage.getCountDish(1),"1");
        Assert.assertTrue(waiter.isElementPresent(newOrderPage.addCommentFirst));
        Assert.assertEquals(newOrderPage.getPrice(1),"385 р.");
        Assert.assertEquals(newOrderPage.getDiscount(1),"0 р.");
        Assert.assertEquals(newOrderPage.getCost(1),"385 р.");

        newOrderPage.clickProduct(newOrderPage.nonalc);
        nonAlcoholPage.clickMorseBerryBtn();
        newOrderPage.clickAddIcon(2);
        Assert.assertTrue(newOrderPage.countAddedProducts()==2);
        Assert.assertEquals(newOrderPage.getNumberProduct(2),"2");
        Assert.assertEquals(newOrderPage.getNameProduct(2),nonAlcoholPage.morseBerryName);
        Assert.assertFalse(waiter.isElementPresent(newOrderPage.plusIconSecond));
        Assert.assertEquals(newOrderPage.getCountDish(2),"2");
        Assert.assertTrue(waiter.isElementPresent(newOrderPage.addCommentSecond));
        Assert.assertEquals(newOrderPage.getPrice(2),"220 р.");
        Assert.assertEquals(newOrderPage.getDiscount(2),"0 р.");
        Assert.assertEquals(newOrderPage.getCost(2),"440 р.");
        Assert.assertEquals(newOrderPage.getTotalCost(),"825,00");
    }

    @Test(description = "Заполнение данных о клиенте", dependsOnMethods = "TC1")
    public void TC2() throws InterruptedException {
        newOrderPage.clickOrder();
        orderTabPage.inputPhoneFld();
        orderTabPage.inputNameFld();
        orderTabPage.clickFirstAddress();
        orderTabPage.selectPaymentType(orderTabPage.paymentType);
        Assert.assertEquals(orderTabPage.getFilialFld(),"Новокузнецкий");
        Assert.assertEquals(orderTabPage.getSourceFld(), "Телефон");
        Assert.assertEquals(orderTabPage.getDealFld(), "1000");
        Assert.assertEquals(orderTabPage.getTotalCostFld(),"825,00 р.");
        orderTabPage.clickCook();
        waiter.isElementPresentWaiters(allPage.searchFld);
        Assert.assertTrue(allPage.getCurrentUrl().contains(allPage.getUrl()));

    }

    @Test(description = "Заполнение данных о клиенте", dependsOnMethods = {"TC1", "TC2"})
    public void TC3() throws InterruptedException {
        allPage.inputSearchFld();
        allPage.clickSearchBtn();
        waiter.waiterLoadingPage();
        Assert.assertEquals(allPage.getLastStatus(),allPage.status);
        Assert.assertEquals(allPage.getLastFilial(),allPage.filial);
        Assert.assertEquals(allPage.getLastAddress(),allPage.address);
        Assert.assertEquals(allPage.getLastClient(),allPage.client);
        Assert.assertEquals(allPage.getLastCost(),allPage.cost);

    }






    @AfterSuite
    public void closebrowser() {
       driver.quit();
    }




}
