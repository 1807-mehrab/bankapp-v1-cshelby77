import java.util.Scanner;
import Accounts.*;

public class Main {
    private Parser parser;
    private CommandWords commandwords;
    private AccountsDB accountsDB;
    private Account userAccount;


    public static void main(String[] args) {
        Main mainObject = new Main();
        

        System.out.println("Hello. Thank you for choosing SimpleBankingApp.");

        System.out.println("How can we help?");
        System.out.println("Create Account? type 'create'");
        System.out.println("Already have one? type 'login'");
        mainObject.processCommand();

        System.out.println("Make a deposit? type 'deposit'");
        System.out.println("Withdraw funds? type 'withdraw'");


    }

    public Main() {
        parser = new Parser();
        commandwords = new CommandWords();
    }

    private boolean processCommand() {
        String inputString = parser.getCommand();
        if(!commandwords.isCommand(inputString)) {
            System.out.println("I don't understand!");
            return false;
        }
        if(!isLoggedIn()) {
            if (inputString.equals("login")) {
                if (isLoggedIn()) {
                    System.out.println("You are already loggedin");
                } else {
                    logIn();
                }
            } else if (inputString.equals("create")){
                createAccount();
            } else {
                System.out.println("Please login or Create an account" );
            }
        } else if (inputString.equals("logout")) {
            if (isLoggedIn()) {
                logOut();
            } else {
                System.out.println("You are not logged in");
            }
        } else if (inputString.equals("deposit")) {
            if(isLoggedIn()){
                depositMoney();
            } else {
                System.out.println("Please Login");
            }
        } else if (inputString.equals("withdraw")){
            boolean x = false;
            if (isLoggedIn()) {
                x = withdrawMoney();
                if (x) {
                    System.out.println("Current Balance: $" + userAccount.getAmount());
                } else {
                    System.out.println("Insufficient funds");
                }
            } else {
                System.out.println("Please Login");
            }
            
        }

        return true;

    }

    private void logIn() {
        Scanner reader = new Scanner(System.in);
        String username = "";
        boolean unusedname = false;
        while (unusedname == false) {
            System.out.println("User Name: ");
            username = reader.next();
            if (!accountsDB.doesAccountExist(username)) {
                unusedname = true;
            }
        }
        userAccount = accountsDB.getAccount(username);

        reader.close();
    }

    private void logOut() {
        if (isLoggedIn()) {
            userAccount = null;
        }
    }

    private boolean isLoggedIn() {
        if(userAccount) {
            return true;
        }
        return false;
    }

    private boolean createAccount() {
        Account tempAccount;
        Scanner reader = new Scanner(System.in);
        String username, name, dob;
        boolean x = false;
        while (x == false) {
            System.out.println("User Name? ");
            username = reader.next();
            if (!accountsDB.doesAccountExist(username)) {
                x = true;
            }
        }

        System.out.println("First Name?");
        name = reader.next();

        System.out.println("Date of Birth? MM/DD/YYYY");
        dob = reader.next();
        reader.close();

        tempAccount = new Account(name, dob, username);
        
        accountsDB.addAccount(tempAccount);

        userAccount = tempAccount;
        
        return true;
    }

    private boolean withdrawMoney() {

        Scanner reader = new Scanner(System.in);
        String amount, name, dob;
        boolean x = false;

        while (x == false) {
            System.out.println("User Name? ");
            username = reader.next();
            if (!accountsDB.doesAccountExist(username)) {
                x = true;
            }
        }

        System.out.println("How much do you want to withdraw?");
        amount = reader.next();

        reader.colse();
        System.out.println("Thank You.");
        return userAccount.withdrawMoney((double) amount);
    }

    private void depositMoney() {

        Scanner reader = new Scanner(System.in);
        String amount, name, dob;
        boolean x = false;

        while (x == false) {
            System.out.println("User Name? ");
            username = reader.next();
            if (!accountsDB.doesAccountExist(username)) {
                x = true;
            }
        }

        System.out.println("How much do you want to withdraw?");
        amount = reader.next();

        reader.colse();
        System.out.println("Thank You");
        userAccount.depositMoney((double) amount);

        System.out.println("You deposited $" + amount + " amount");
        //System.out.println("Current Balance: $" + userAccount.getAmount());
 
    }
}