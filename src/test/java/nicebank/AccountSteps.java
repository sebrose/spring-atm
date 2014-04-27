package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import transforms.MoneyConverter;

@ContextConfiguration("classpath:cucumber.xml")
public class AccountSteps {

  @Autowired
  private Account testAccount;

  @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
  public void My_account_has_been_credited_with_d(@Transform(MoneyConverter.class) Money amount) 
                                                              throws Throwable {
      testAccount.credit(amount);
  }

  // START:balance-check
  @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
  public void the_balance_of_my_account_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
      int timeoutMilliSecs = 3000;
      int pollIntervalMilliSecs = 100;
      boolean assertionNotPassedYet = true;

      while (assertionNotPassedYet){
          try {
            Assert.assertEquals("Incorrect account balance -", amount, testAccount.getBalance());
            assertionNotPassedYet = false;
          } catch (AssertionError ae) {
              try {
                  Thread.sleep(pollIntervalMilliSecs);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              timeoutMilliSecs -= pollIntervalMilliSecs;

              if (timeoutMilliSecs <= 0) {
                  throw ae;
              }
          }
      }
  }
  // END:balance-check
}