package support;

import nicebank.Account;
import org.javalite.activejdbc.Base;

public class AccountFactory {

    public static Account createTestAccount() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }

        Account.deleteAll();

        Account testAccount = new Account(1234);
        testAccount.saveIt();
        return testAccount;
    }

}
