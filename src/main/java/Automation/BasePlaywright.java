package Automation;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BasePlaywright {
    public static Playwright playwright;
    public static Page page;
    public static Browser browser;

    @Parameters({"url","userId","accessKey"})
    @BeforeSuite
    public void firstSampleTest(String url, String username, String accessKey) throws UnsupportedEncodingException {
        playwright = Playwright.create();
        JsonObject capabilities = new JsonObject();
        JsonObject ltOptions = new JsonObject();

/*
        capabilities.addProperty("browsername", "pw-chromium");
        capabilities.addProperty("browserVersion", "latest");
        ltOptions.addProperty("platform", "Windows 10");
        ltOptions.addProperty("name", "Playwright Test");
        ltOptions.addProperty("build", "Playwrite Testing in Java");
        ltOptions.addProperty("user", username);
        ltOptions.addProperty("accessKey", accessKey);
        capabilities.add("LT:Options", ltOptions);
*/

        BrowserType chromium = playwright.chromium();
        String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
        String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capabilities;
        browser = chromium.connect(cdpUrl);
        page = browser.newPage();
        page.navigate(url);
    }

    @AfterSuite
    public void killServer(){
        browser.close();
    }
}
