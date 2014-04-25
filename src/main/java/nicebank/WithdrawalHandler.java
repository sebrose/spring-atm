package nicebank;

import org.webbitserver.HttpControl;
import org.webbitserver.HttpHandler;
import org.webbitserver.HttpRequest;
import org.webbitserver.HttpResponse;

public class WithdrawalHandler implements HttpHandler {
    private CashSlot cashSlot;
    private Account account;
    
    public WithdrawalHandler(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }
    
    // START:withdrawal
    @Override
    public void handleHttpRequest(HttpRequest request, HttpResponse response, HttpControl control) {
        Teller teller = new AutomatedTeller(cashSlot);
        int amount = Integer.parseInt(request.postParam("amount"));
        teller.withdrawFrom(account, amount);
        response.header("Content-type", "text/html")
            .content("<html><head><title>ATM</title></head><body>Please take your $" + amount + "</body></html>")
            .end();
    }
    // END:withdrawal
}