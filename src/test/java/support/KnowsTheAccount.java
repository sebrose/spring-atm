package support;

import nicebank.Account;
import nicebank.Money;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Component;

@Component
//@ContextConfiguration("classpath:cucumber.xml")
public class KnowsTheAccount {
    private final Account myAccount;

    public KnowsTheAccount() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }

        Account.deleteAll();

        myAccount = new Account(1234);
        myAccount.saveIt();
    }

    public void credit(Money amount) {
        myAccount.credit(amount);
    }

    public Money getBalance() {
        return myAccount.getBalance();
    }

    public Account getMyAccount() {
        return myAccount;
    }
}
