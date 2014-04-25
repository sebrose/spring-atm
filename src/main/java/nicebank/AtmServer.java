package nicebank;

import org.webbitserver.WebServer;
import org.webbitserver.WebServers;

import org.javalite.activejdbc.Base;

import java.io.IOException;
import java.net.URI;

public class AtmServer {
    private final WebServer webServer;

    // START:shared-params
    public AtmServer(int port, CashSlot cashSlot, Account account) {
        webServer = WebServers.createWebServer(port);
        webServer
            .add("/withdraw", new WithdrawalHandler(cashSlot, account))
            .add(new AtmHandler(cashSlot));
    }
    // END:shared-params

    public void start() throws IOException {
        webServer.start();
        System.out.println("Listening on " + webServer.getUri());
    }

    public void stop() throws IOException {
        webServer.stop();
    }

    // START:main
    public static void main(String[] args) throws IOException {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/bank", "teller", "password");
        new AtmServer(9988, new CashSlot(), new Account()).start();
    }
    // END:main
}
