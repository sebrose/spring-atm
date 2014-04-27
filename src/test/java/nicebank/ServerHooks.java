package nicebank;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

@ContextConfiguration("classpath:cucumber.xml")
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer atmServer;

    @Autowired
    private CashSlot cashSlot;

    @Autowired
    private Account account;

    // START:server-init
    @Before
    public void startServer() throws IOException {
        atmServer = new AtmServer(PORT, cashSlot, account);
        atmServer.start();
    }
    // END:server-init

    @After
    public void stopServer() throws IOException {
        atmServer.stop();
    }
}
