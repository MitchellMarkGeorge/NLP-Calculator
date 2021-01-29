/**
 * This class houses the utility methods for the tokenizer
 * @author
 */

package internals;
public class Utils {

    // a list of all the acceptable opperators
    private static String[] OPERATORS = new String[] {"=", "+", "-", "*", "/" }; //"<=" , ">=", "==", "!="
    
    /**
     * method that tests if a string is an operator
     * @param tokenValue string to be tested
     * @return a boolean to see if it it an operator
     */
    public static boolean isOperator(String tokenValue) {
        if (tokenValue.isEmpty() || tokenValue.equals("EOL")) return false;

        for (String operator: Utils.OPERATORS) {
            if (operator.equalsIgnoreCase(tokenValue)) return true;
        }
        
        return false;
        
    }

    /**
     * method that tests if a string is a number (including decimals)
     * @param tokenValue string to be tested
     * @return a boolean to see if it it a number
     */
    public static boolean isNumber(String tokenValue) {
        if (tokenValue.isEmpty()) return false;
        for (char character : tokenValue.toCharArray()) {
            if (Character.isDigit(character) || character == '.') {
                return true;
            }
            
        }

        return false;
    }

    
}
