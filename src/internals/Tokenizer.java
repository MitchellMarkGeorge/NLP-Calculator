/**
 * A class that is responsble for tokenizing a string expression into a list of tokens.
 * It also has a private method that "translates" all word operators and number-words to operators and numbers respectively
 * @author Mitchell Mark-George
 */

package internals;
// All neccessary imports
import java.util.ArrayList;
import java.util.HashMap;
import internals.tokens.*;
import internals.tokens.ParenthesesToken.ParenType;

public class Tokenizer {

    // initallizing all the nesseccarry fields
    private HashMap<String, String> WORD_OPPERATORS = new HashMap<>();
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private HashMap<String, String> NUMBERS_AS_WORDS = new HashMap<>();
   

    /**
     * The constructor that initalizes the word-opperator and number-word dictionaries
     */
    public Tokenizer() {
        // creates a dictionary of all word operator and their respective operator values
        WORD_OPPERATORS.put("plus", "+");
        WORD_OPPERATORS.put("add", "+");
        WORD_OPPERATORS.put("times", "*");
        WORD_OPPERATORS.put("minus", "-");
        WORD_OPPERATORS.put("multiply", "*");
        WORD_OPPERATORS.put("divide", "/");
        WORD_OPPERATORS.put("over", "/");

        // creates a dictionary of all number-words and their respective number values (only supports numbers 0 - 10)
        NUMBERS_AS_WORDS.put("one", "1");
        NUMBERS_AS_WORDS.put("two", "2");
        NUMBERS_AS_WORDS.put("three", "3");
        NUMBERS_AS_WORDS.put("four", "4");
        NUMBERS_AS_WORDS.put("five", "5");
        NUMBERS_AS_WORDS.put("six", "6");
        NUMBERS_AS_WORDS.put("seven", "7");
        NUMBERS_AS_WORDS.put("eight", "8");
        NUMBERS_AS_WORDS.put("nine", "9");
        NUMBERS_AS_WORDS.put("ten", "10");
        NUMBERS_AS_WORDS.put("zero", "0");
    }

   

    

    /**
     * A method that tokenizing a string expression into a list of tokens (all depending on their tupes)
     * @param expression a string expression
     * @return list of corresponding tokens
     */
    public ArrayList<Token> tokenizeExpression(String expression) {
        
        // this retuns back a expression this all word operators and tokens resolved to their corresponding values
        expression = transformExpression(expression);
         
        // a buffer to build up multicharacter tokens (especially numbers: "423")
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            // adds the current charcter to the buffer
            buffer.append(currentChar);
            // if the index of the next token is more than the length of the string (i.e out of bounds).
            // assign token to a special character. Else, just get the character at the approptiate indec
            String nextToken = (i + 1) >= expression.length() ? "\0" : Character.toString(expression.charAt(i + 1));
            
        
            // this gets the string value of the buffer and removes all the spaces,
            //allowing expressions like "1 + 2" and "1+2" to be evaluated equally with no errors
            String stringBuffer = buffer.toString().trim();
           

           
            // if the string buffer is a number value and the next token isnt, 
            //create a new number token and add it to the token array
            if (Utils.isNumber(stringBuffer) && !Utils.isNumber(nextToken)) {
                
                tokens.add(new NumberToken(stringBuffer));
                buffer.setLength(0); // empty the buffer for next token
            }

            // if the string buffer is an operator value, 
            //create a new operator token and add it to the token array
            if (Utils.isOperator(stringBuffer)) {
                
                tokens.add(new OperatorToken(stringBuffer));
                buffer.setLength(0);
            }

            // These checks if the string buffer is a parentheses
            // and if it is, it adds a new parentheses token with the asociated type
            if (stringBuffer.equals("(")) {
                tokens.add(new ParenthesesToken(ParenType.LEFT));
                buffer.setLength(0);
            }

            if (stringBuffer.equals(")")) {
                tokens.add(new ParenthesesToken(ParenType.RIGHT));
                buffer.setLength(0);
            }

        }

        

        return tokens; // return the list of tokens
    }

    /**
     * A method that "translates" all word operators and number-words in a string expression into operators and numbers respectively
     * @param expression the string expression to be translated
     * @return the "translated" string expression
     */
    private String transformExpression(String expression) {
        // merges the two dictionary into a single one
        HashMap<String, String> merge = new HashMap<>();

        merge.putAll(NUMBERS_AS_WORDS);
        merge.putAll(WORD_OPPERATORS);

        // iterates over the merged dictionaries and reaplaces all the keys values 
        // in the expression with their accossiated value from the dictionary
        for (HashMap.Entry<String, String> entry : merge.entrySet()) {

            expression = expression.replaceAll(entry.getKey(), entry.getValue());
        }
        return expression; // retun the new string exopression
    }
}
