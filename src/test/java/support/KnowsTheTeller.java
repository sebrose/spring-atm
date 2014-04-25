package support;

import nicebank.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@ContextConfiguration("classpath:cucumber.xml")
public class KnowsTheTeller {
    @Autowired
    private AtmUserInterface atmUserInterface;

    // START:tell-dont-ask
    public void withdrawFrom(Account account, int amount) {
        atmUserInterface.withdrawFrom(account, amount);
    }

    public boolean isAcceptingWithdrawalRequests() {
        return atmUserInterface.isAcceptingWithdrawalRequests();
    }
    // END:tell-dont-ask
}
