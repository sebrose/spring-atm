package nicebank;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
@ContextConfiguration("classpath:cucumber.xml")
public class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before
    public void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };

        transactionProcessorThread.start();
    }

    @After
    public void stopServer() {
        transactionProcessorThread.interrupt();
    }
}
