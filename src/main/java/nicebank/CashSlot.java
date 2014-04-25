package nicebank;

public class CashSlot {
    private int contents;
    private boolean faulty;

    public int contents() {
        return contents;
    }
    
    public void dispense(int dollars){
        contents = dollars;
    }
    
    // START:faulty
    public void setFaulty() {
        faulty = true;
    }

    public boolean isFaulty() {
        return faulty;
    }
    // END:faulty
}
