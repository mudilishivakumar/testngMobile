package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExploreTheApp {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"NewContentfulLandingPageScreenDaznExploreButton\"]")
    WebElement exploreTheAppButton;

    @FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"image\"])[1]")
    WebElement exploreTheAppButtonImage;


    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.dazn:id/tile_description\"])[2]")
    WebElement FreeToWatchSwipeRight;
    @FindBy(xpath = "//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[45]")
    WebElement FreeToWatchSwipeLeft;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.dazn:id/overlay_background\"]")
    WebElement Play;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    WebElement Home;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dazn:id/menu_title\" and @text=\"Landing Page\"]")
    WebElement LandingPage;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.dazn:id/btn_accept_cookies\"]")
    WebElement cookies;
    //android.widget.Button[@resource-id="com.dazn:id/btn_accept_cookies"]


    public WebElement exploreTheAppButtonImage(WebDriver driver) {

        return (exploreTheAppButtonImage);
    }

    public WebElement cookies(WebDriver driver) {

        return (cookies);
    }


    public WebElement LandingPage(WebDriver driver) {

        return (LandingPage);
    }


    public WebElement Home(WebDriver driver) {

        return (Home);
    }

    public WebElement Play(WebDriver driver) {

        return (Play);
    }

    public WebElement exploreTheAppButton(WebDriver driver) {

        return (exploreTheAppButton);
    }

    //    public By FreeToWatchSwipeRight(WebDriver driver) {
//
//        return (FreeToWatchSwipeRight) ;
//    }
    public WebElement FreeToWatchSwipeLeft(WebDriver driver) {

        return (FreeToWatchSwipeLeft);
    }


}

