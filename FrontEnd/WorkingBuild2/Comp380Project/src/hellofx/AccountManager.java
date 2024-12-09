package hellofx;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountManager {
    private static ArrayList<Account> allAccounts = new ArrayList<>();
    private static Iterator<Account> accountIterator;
    public  static Account currentAccount;

    private static final Account Default_Account = new Account("Homer", "Simpson", "DonutLover@DuffBeer.com", 
                                               "donuts123", "May", "12", "1956", "742 Evergreen Terrace",
                                                   "Springfield", "Oregon", "97403", "1234 5678 9123 4567", 
                                                    "123", "06/22", "1111"                                              );

    public static void addAccount(Account account){
        allAccounts.add(account);
        account.exportThis();
    }
    
    public static Account getDefaultAccount(){
        return allAccounts.get(0);
    }

    public static void setCurrentAccount(Account account){
        currentAccount = account;
    }

    public static String getSalt(String email){
        accountIterator = allAccounts.iterator();
        while (accountIterator.hasNext()){
            Account tempAccount = accountIterator.next();
            if (tempAccount.getEmail().equalsIgnoreCase(email)){
                    return tempAccount.getSalt();
            }
            else{}   
        }
        return null;
    }
    
    public static Account getAccount(String email, String password){
        accountIterator = allAccounts.iterator();
        while (accountIterator.hasNext()){
            Account tempAccount = accountIterator.next();
            if (tempAccount.getEmail().equalsIgnoreCase(email)){
                if (tempAccount.getPassword().equalsIgnoreCase(password))
                    return tempAccount;
            }
            else{}   
        }
        return null;
    }

    public static Account getAccount(String email) {
        accountIterator = allAccounts.iterator();
        while (accountIterator.hasNext()) {
            Account tempAccount = accountIterator.next();
            if (tempAccount.getEmail().equalsIgnoreCase(email)) {
                return tempAccount; // Return the matching account
            }
        }
        return null; // Return null if no matching account is found
    }
}


