package nicebank;

import cucumber.api.java.Before;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
@ContextConfiguration("classpath:cucumber.xml")
public class ResetHooks {
    @Before
    public void reset() {
        TransactionQueue.clear();
    }
}
