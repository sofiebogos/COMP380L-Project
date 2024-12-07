import java.util.ArrayList;
import java.util.Collections;


// TO DO, email user when a purchase. 

/**
 * @author @version
 *         Can verify Payment or tell you the merchant 
 */

public class Payment {

    /**
     * Takes a CC and can tell you which of the major American merchants it's from
     * @param CrdditCard 
     * Returns the name of the merchant as a string
     */

    public static String ProviderCheck(long CreditCard){
        String StringCreditCard = Long.toString(CreditCard);
        char firstDigit = StringCreditCard.charAt(0);
        int digit = Character.getNumericValue(firstDigit);
        if (digit == 3){
            return "American Express";
        }
        if (digit == 4){
            return "Visa";
        }
        if (digit == 5 ){
            return "Mastercard";
        }
        if (digit == 6){
            return "Discover";
        }
        return "Error";
    }

    /**
     * Takes a CC and can tell you if it's a real CC using Lehn's Algorithm
     * @param CrdditCard 
     * returns a bool based on if it is or not
     */

    public static boolean PaymentCheck(long CreditCard) {
        String StringCreditCard = Long.toString(CreditCard);
        // String payload = StringCreditCard.substring(1);
        // char checkDigit = payload.charAt(payload.length()-1);
        // int checkDigitInt = Character.getNumericValue(checkDigit);
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < (StringCreditCard.length()); i++) {
            char a = StringCreditCard.charAt(i);
            int b = Character.getNumericValue(a); 
            array.add(b);
        }
        Collections.reverse(array);
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if ((i % 2) != 0){
                int a = 2 * array.get(i);
                if (a > 9){
                    a = a - 9; 
                }
                sum = sum + a; 
            } else {
                sum = sum + array.get(i); 
            }
        }
        int CHECK = ((10 - (sum % 10)) % 10);
        if (sum % 10 == 0){
            return true;
        } else {
            return false; 
        }

    }
}
