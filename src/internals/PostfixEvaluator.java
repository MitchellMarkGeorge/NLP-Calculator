/**
 * This class has a method that evalutes a list of tokens (arranged in postfix notation)
 * and retuns a number as a result
 * 
 * @author Mitchell Mark-George
 */

package internals;
import java.util.ArrayList;
import java.util.Stack;
// All neccessary imports
import internals.tokens.NumberToken;
import internals.tokens.OperatorToken;
import internals.tokens.Token;
public class PostfixEvaluator {

    /**
     * A method that evalutes a list of tokens (arranged in postfix notation)
     * @param tokens  list of tokens (arranged in postfix notation)
     * @return the result of the evaluation
     */
    public static double evaluate(ArrayList<Token> tokens) {
        Stack<Double> stack = new Stack<>();
        
        for (Token token : tokens) {
            // if the token is a number, push the number value of the token onto the stack
            if (token instanceof NumberToken) {
                stack.push(Double.parseDouble(token.getValue()));
            } else {
                // This mean the token is an operator
                // Pop the two top numbers from the stack;
                double number1 = stack.pop();
                double number2 = stack.pop();
                // Cast the current token to and OperatorToken and evaluate it appropiatly
                //push the result onto the stack
                OperatorToken operatorToken = (OperatorToken)token;
                stack.push(operatorToken.getOperator().evaluate(number2, number1));
                
            }
        }

        return stack.pop(); // return the number at the top of the stack (the result of the evaaluation)
    }

    
}
    
    

