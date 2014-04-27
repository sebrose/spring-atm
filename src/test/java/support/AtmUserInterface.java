package support;

import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class AtmUserInterface implements Teller {

    @Autowired
    private EventFiringWebDriver webDriver;

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

}
