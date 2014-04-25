package nicebank;

import org.javalite.activejdbc.Model;

// START:account-class
public class Account extends Model {
  private TransactionQueue queue = new TransactionQueue();
  
  // START:ctor
  public Account() {}
  
  public Account(int number){
      setInteger("number", number);
  }
  // END:ctor
  
  public void credit(Money amount) {
      queue.write("+" + amount.toString() + "," + getNumber());
  }
  
  public void debit(int dollars) {
      Money amount = new Money(dollars, 0);
      queue.write("-" + amount.toString() + "," + getNumber());
  }
  
  public int getNumber() {
      return getInteger("number");
  }

  // START:refresh
  public Money getBalance() {
      refresh();
      return new Money(getString("balance"));
  }
  // END:refresh

  public void setBalance(Money amount) {
      setString("balance", amount.toString());
      saveIt();
  }
}
// END:account-class
