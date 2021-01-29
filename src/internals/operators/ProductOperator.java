/**
 * This is a class that represents the Multiplication Operator (*).
 *  It also implments an evaluate method that multiplies two numbers 
 * @author Mitchell Mark-George
 */

package internals.operators;
public class ProductOperator extends Operator {

     /**
     * A constructor that sets the precedence of the operator
     */
    public ProductOperator() {
        this.precedence = 2;

    }

    /**
     * @return the string respresentation of the Operator. Mostly used for printing
     */
    @Override
    public String toString() {
        return "*";
    }

    /**
     * A method that multiplies two numbers (how the operator evaluates)
     * 
     * @return the result of the multiplication
     */
    @Override
    public double evaluate(double first, double second) {
        return first * second;
    }

}
