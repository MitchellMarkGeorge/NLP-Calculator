/**
 * This is a class that represents the Division Operator (/).
 *  It also implments an evaluate method that divides two numbers 
 * @author Mitchell Mark-George
 */

package internals.operators;

public class DivisionOperator extends Operator {
    /**
     * A constructor that sets the precedence of the operator
     */
    public DivisionOperator() {
        this.precedence = 2;

    }

    /**
     * @return the string respresentation of the Operator. Mostly used for printing
     */
    @Override
    public String toString() {
        return "/";
    }

    /**
     * A method that divides two numbers (how the operator evaluates)
     * 
     * @return the result of the division
     */
    @Override
    public double evaluate(double first, double second) {
        return first / second;
    }

}
