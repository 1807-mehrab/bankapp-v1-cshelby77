package Accounts;

public class AccountsDB {
    private List<Account> database;

    AccountsDB() {
        database = new ArrayList<>();
    }

    public boolean doesAccountExist(String id) {
        for (Account x : database) {
            if(x.getProfileId() == id) {
                return true;
            }
        }

        return false;
    }

    public void addAccount(Account x) {
        database.add(x);
    }

    public Account getAccount(String id) {
        for (Account x : database) {
            if(x.getProfileId() == id) {
                return x;
            }
        }
        
    }


    
}