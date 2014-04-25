package nicebank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import support.KnowsTheAccount;
import support.KnowsTheTeller;

@ContextConfiguration("classpath:cucumber.xml")
public class TellerSteps {

  @Autowired
  private KnowsTheAccount accountHelper;

  @Autowired
  private KnowsTheTeller tellerHelper;

  @Given("^I withdraw \\$(\\d+)$")
  public void I_withdraw_d(int amount) throws Throwable {
      tellerHelper.withdrawFrom(accountHelper.getMyAccount(), amount);
  }
  
  @Then("the teller will not accept withdrawal requests")
  public void noWithdrawalRequestsAccepted() throws Throwable {
      Assert.assertFalse("Should not accept withdrawal requests -", tellerHelper.isAcceptingWithdrawalRequests());
  }
}