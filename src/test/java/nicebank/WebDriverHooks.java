package nicebank;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import support.AtmUserInterface;


@Component
@ContextConfiguration("classpath:cucumber.xml")
public class WebDriverHooks {
    @Autowired
    private AtmUserInterface atmUserInterface;

    @After
    public void finish(Scenario scenario) {
        try {
            atmUserInterface.embedScreenshot(scenario);
        } finally {
            atmUserInterface.closeDriver();
        }
    }
}
