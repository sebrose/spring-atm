package nicebank;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import support.KnowsTheAccount;
import support.KnowsTheCashSlot;

import java.io.IOException;

@Component
@ContextConfiguration("classpath:cucumber.xml")
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer atmServer;
    @Autowired
    private KnowsTheCashSlot cashSlotHelper;

    @Autowired
    private KnowsTheAccount accountHelper;

    // START:server-init
    @Before
    public void startServer() throws IOException {
        atmServer = new AtmServer(PORT, cashSlotHelper.getCashSlot(), accountHelper.getMyAccount());
        atmServer.start();
    }
    // END:server-init

    @After
    public void stopServer() throws IOException {
        atmServer.stop();
    }
}
