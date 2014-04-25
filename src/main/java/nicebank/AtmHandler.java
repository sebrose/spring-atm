package nicebank;

import org.webbitserver.HttpControl;
import org.webbitserver.HttpHandler;
import org.webbitserver.HttpRequest;
import org.webbitserver.HttpResponse;

public class AtmHandler implements HttpHandler {
    private final CashSlot cashSlot;
    
    public AtmHandler(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }
    
    @Override
    public void handleHttpRequest(HttpRequest request, HttpResponse response, HttpControl control) {
        if (cashSlot.isFaulty()) {
          response.header("Content-type", "text/html")
          .content("<html><head><title>ATM</title></head><body>Out of order</body></html>")
          .end();
        } else {
          response.header("Content-type", "text/html")
          .content("<html><head><title>ATM</title></head><body><form action=\"/withdraw\" method=\"post\">" +
               "<label for=\"amount\">Amount</label>" +
               "<input type=\"text\" id=\"amount\" name=\"amount\">" +
               "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
               "</form></body></html>")
          .end();
        }
    }
}