package nicebank;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class CashSlotSteps {

  private CashSlot cashSlot;

  @Autowired
  public CashSlotSteps(CashSlot cs) {
      cashSlot = cs;

  }

  @Given("^\\$(\\d+) should be dispensed$")
  public void d_should_be_dispensed(int amount) throws Throwable {
    Assert.assertEquals("Incorrect amount dispensed -", amount, cashSlot.contents());
  }

  // START:faulty
  @Given("^the cashslot is faulty$")
  public void the_cashslot_is_faulty() throws Throwable {
    cashSlot.setFaulty();
  }
  // END:faulty
}