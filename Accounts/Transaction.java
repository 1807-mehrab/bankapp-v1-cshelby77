package Accounts;

public class Transaction {
    private String accountid;
    private String date;
    private boolean madedeposit;
    private double amounttransfered;

    Transaction(accountid, date, madedeposit, amounttransfered) {
        this.accountid = accountid;
        this.date = date;
        this.madedeposit = madedeposit;
        this.amounttransfered= amounttransfered;
        
    }

    public String toString() {
        if(madedeposit) {
            return "Account: " + accountid + ", Date: " + date + ", Deposited: " + amounttransfered;
        }
        return "Account: " + accountid + ", Date: " + date + ", Withdrew: " + amounttransfered;
    }

   
}