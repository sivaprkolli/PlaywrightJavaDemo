package PlayWrightTests;



import Automation.BasePlaywright;
import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceLogin {
    Playwright playwright;
    @Test
    public void sauceLogin(){
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserType browserType = browser.browserType().launch(new BrowserType.LaunchOptions().setTimeout(6000)).browserType();
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://www.saucedemo.com/");
        page.fill("#user-name", "standard_user");
        page.fill("#password", "secret_sauce");

    }

}
