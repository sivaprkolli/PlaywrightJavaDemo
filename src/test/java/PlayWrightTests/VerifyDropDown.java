package PlayWrightTests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

public class VerifyDropDown {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    @Test
    public void registration(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        page.selectOption("select[id^='UserTitle']", "Customer Service Manager");

        Locator dropDown = page.locator("[name='CompanyEmployees']");
        dropDown.selectOption("26 - 100 employees");
                //selectOption("[name='CompanyEmployees']","26 - 100 employees");
        dropDown.selectOption(new SelectOption().setLabel("501 - 2000 employees"));
    }
}
