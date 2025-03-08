package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"NewContentfulLandingPageScreenSignInButton\"]")
    WebElement signINButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    WebElement Allow;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.gms:id/cancel\"]")
    WebElement cancel;


    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.dazn:id/email_input\"]")
    WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.dazn:id/password_input\"]")
    WebElement password;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.dazn:id/login_button\"]")
    WebElement loginButton;


    public WebElement Allow(WebDriver driver) {
        return (Allow);
    }

    public WebElement signINButton(WebDriver driver) {
        return (signINButton);
    }

    public WebElement username(WebDriver driver) {
        return (username);
    }

    public WebElement password(WebDriver driver) {
        return (password);
    }

    public WebElement lgnBtn(WebDriver driver) {
        return (loginButton);
    }

    public WebElement cancel(WebDriver driver) {
        return (cancel);
    }

}
