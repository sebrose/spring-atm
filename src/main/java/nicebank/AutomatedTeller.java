package nicebank;

public class AutomatedTeller implements Teller {
    private CashSlot cashSlot;
    
    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }
    
    public void withdrawFrom(Account account, int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
    
    public boolean isAcceptingWithdrawalRequests() {
        return !cashSlot.isFaulty();
    }
}
