package support;

import cucumber.api.Scenario;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.stereotype.Component;

@Component
//@Scope("cucumber-glue")
//@ContextConfiguration("classpath:cucumber.xml")
public class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver = new EventFiringWebDriver( new FirefoxDriver() );

    public void withdrawFrom(Account account, int amount) {
            // START:port
            webDriver.get("http://localhost:" + nicebank.ServerHooks.PORT);
            // END:port
            webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(amount));
            webDriver.findElement(By.id("withdraw")).click();
    }
    
    public boolean isAcceptingWithdrawalRequests() {
        webDriver.get("http://localhost:" + nicebank.ServerHooks.PORT);
        return !webDriver.getPageSource().contains("Out of order");
    }

    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

    public void closeDriver() {
        webDriver.close();
    }
}
