import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Администратор on 17.03.2017.
 */
public class Login {

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private By loginFld = By.id("inputLogin");
    private By passwordFld = By.id("inputPassword");
    private By loginBtn = By.xpath("//button[@type='submit']");

    private String login = "tester";
    private String password = "tester";


    public void inputLogin(){
        driver.findElement(loginFld).sendKeys(login);
    }

    public void inputPassword(){
        driver.findElement(passwordFld).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void loginComplete(){
        inputLogin();
        inputPassword();
        clickLoginBtn();
    }




}
