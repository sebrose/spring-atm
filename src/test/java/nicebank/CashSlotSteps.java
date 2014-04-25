package nicebank;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import support.KnowsTheCashSlot;

@ContextConfiguration("classpath:cucumber.xml")
public class CashSlotSteps {

  @Autowired
  KnowsTheCashSlot cashSlotHelper;

  @Given("^\\$(\\d+) should be dispensed$")
  public void d_should_be_dispensed(int amount) throws Throwable {
    Assert.assertEquals("Incorrect amount dispensed -", amount, cashSlotHelper.getContents());
  }

  // START:faulty
  @Given("^the cashslot is faulty$")
  public void the_cashslot_is_faulty() throws Throwable {
    cashSlotHelper.setFaulty();
  }
  // END:faulty
}