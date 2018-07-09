import java.util.ArrayList;
package Accounts;

public class Account extends Profile {
    private String accountid; //This would be used in a sqlDB not used here
    private double amount;
    private List<Transaction> transactionsmade;

    Account(String name, String dob, String username) {
        super(name, dob, username);
        this.accountid = generateId();
        amount = 0.0;
        transactionsmade = new ArrayList<>();
        }
    
    /**
     * @return the accountid
     */
    public String getAccountid() {
        return accountid;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    private String generateId() {
        Random rand = new Random();
        int n = rand.nextInt();
        return (String) n;
    } 
    
    public boolean withdrawMoney(double amount) {
        double temp = this.amount - amount;
        String testDate = "1/1/2010";
        
        if(temp < 0.0) {
            return false;
        }
        this.amount = temp;

        Transaction transactioncreated = new Transaction(accountid, testDate, false, this.amount);
        transactionsmade.add(transactioncreated);
        
        return true;
    }

    public void depositMoney(double amount) {
        String testDate = "5/8/2020";
        this.amount += amount;

        Transaction transactioncreated = new Transaction(accountid, testDate, true, this.amount);
        transactionsmade.add(transactioncreated);
    }
}