/**
 * This is a class that represents the Addition Operator (+).
 *  It also implments an evaluate method that adds two numbers 
 * @author Mitchell Mark-George
 */

package internals.operators;

public class AddOperator extends Operator {

    /**
     * A constructor that sets the precedence of the operator
     */
    public AddOperator() {
        this.precedence = 1;

    }

    /**
     * @return the string respresentation of the Operator. Mostly used for printing
     */
    @Override
    public String toString() {

        return "+";
    }

    /**
     * A method that adds two numbers (how the operator evaluates)
     * 
     * @return the result of the addition
     */
    @Override
    public double evaluate(double first, double second) {
        return first + second;
    }
}
