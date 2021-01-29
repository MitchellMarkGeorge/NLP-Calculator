/**
 * This is a class that represents the Subtraction Operator (-).
 *  It also implments an evaluate method that subtracts two numbers 
 * @author Mitchell Mark-George
 */

package internals.operators;

public class MinusOperator extends Operator {

     /**
     * A constructor that sets the precedence of the operator
     */
    public MinusOperator() {
        this.precedence = 1;

    }
/**
     * @return the string respresentation of the Operator. Mostly used for printing
     */
    @Override
    public String toString() {
        return "-";
    }

    /**
     * A method that subtracts two numbers (how the operator evaluates)
     * 
     * @return the result of the subtraction
     */
    @Override
    public double evaluate(double first, double second) {
        return first - second;
    }
}