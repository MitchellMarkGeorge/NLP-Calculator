/**
 * This class represents the model of the application. It has a method that evaluates
 * string expression and is to be used in the controller in conjunction with the view
 */

// All nesseccary imports
import java.util.ArrayList;
import internals.PostfixConverter;
import internals.PostfixEvaluator;
import internals.Tokenizer;
import internals.tokens.Token;

public class Model {
    private double calculationResult;

    /**
     * a method that evaluates string expression and sets the result to
     * clcultionResult
     * 
     * @param expression the string expression to evaluate
     */
    public void evaluateExpression(String expression) {
        // tokennize the string
        ArrayList<Token> tokens = new Tokenizer().tokenizeExpression(expression);

        PostfixConverter converter = new PostfixConverter();
        // convert the tokens to postfix notation
        ArrayList<Token> newTokens = converter.convert(tokens);

        // evaluate the postfix tokens and save the result
        this.calculationResult = PostfixEvaluator.evaluate(newTokens);
    }

    /**
     * a method that reuns the calculation result
     * @return result of the calculation
     */
    public double getCalculationResult() {
        return calculationResult;
    }

    // public static void main(String[] args) {
    // evaluateExpression("3+2");
    // evaluateExpression("2+5");
    // evaluateExpression("(2+5 * 2) - 4");
    // }
}
