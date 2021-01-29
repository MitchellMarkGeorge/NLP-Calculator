/**
 * This class implements the Visitor design pattern for a list of tokens
 * and is parly responsible for rearanging them into postfix notation
 * @author Mitchell Mark-George
 */

package internals;
// All neccessary imports
import java.util.ArrayList;
import java.util.Stack;
import internals.operators.Operator;
import internals.tokens.*;
import internals.tokens.ParenthesesToken.ParenType;

public class TokenVisitor  {
    // initalizing empty stack for operators and empty "queue" for the output
    private Stack<Token> operatorStack = new Stack<Token>();
    private ArrayList<Token> outputQueue = new ArrayList<Token>();
    
    
    /**
     * Visit function for NumberTokens
     * @param token the NumberToken object
     */
    public void visit(NumberToken token) {
        // just add NumberTokens to the output
        outputQueue.add(token);
    }

    /**
     * Visit function for OperatorToken
     * @param token the OperatorToken object
     */
    public void visit(OperatorToken token) {
        Operator tokenOperator = token.getOperator();
        // repeatedly pop from opperator stack and add to operator each operatorthat has the same precedence as or higher precedence than the operator. 
        while(!operatorStack.isEmpty() && tokenOperator.precedence <= peekTokenPrecedence()) {
            outputQueue.add(operatorStack.pop());
        }
        operatorStack.push(token);
        //add an operator to operator stack.
    }

    /**
     * method to return presedecne of peeked operator
     * @return
     */
    private int peekTokenPrecedence() {
        Token token = operatorStack.peek();
        // If token is an operator, retun precedence
        //else, return 0.
        if (token instanceof OperatorToken) {
            OperatorToken operatorToken = (OperatorToken)token;
            return operatorToken.getOperator().precedence;
        } else {
            return 0;
        }
    
    }

    

    /**
     * Visit function for Parentheses
     * @param token the Parentheses object
     */
    public void visit(ParenthesesToken token) {
        // if token is right parentheses, pop and add it to the oupput till left parentheses is seen
        if (token.getType() == ParenType.RIGHT) { // right
            while (!operatorStack.empty() && !operatorStack.peek().getValue().equals("(")) {
                outputQueue.add(operatorStack.pop());
            }

            if (!operatorStack.empty()) {
                operatorStack.pop();
            } else {
                throw new Error();
            }
        } else {
            operatorStack.push(token); // left
            //add left parentheses to output
        }
    }

    /**
     * a method that retuns the result of the postfic conversion
     * @return tokens arranged in postfix notation
     */
    public ArrayList<Token> getResult() {
        // pop all the remaining operators from 
        // the stack and append them to output
        while(!operatorStack.empty()) {
            outputQueue.add(operatorStack.pop());
        }
        return outputQueue; // return the output
    }
    
}
