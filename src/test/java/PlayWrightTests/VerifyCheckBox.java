package PlayWrightTests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class VerifyCheckBox {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @Test
    public void verifyCheckBox(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();

        page.navigate("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");


    }
}
