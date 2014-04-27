package support;

import nicebank.CashSlot;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class KnowsTheCashSlot {
    private final CashSlot cashSlot;

    public KnowsTheCashSlot() {
        cashSlot = new CashSlot();
    }

    public int getContents() {
        return cashSlot.contents();
    }

    public void setFaulty() {
        cashSlot.setFaulty();
    }

    public CashSlot getCashSlot() {
        return cashSlot;
    }
}
